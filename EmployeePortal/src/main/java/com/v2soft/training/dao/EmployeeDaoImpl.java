package com.v2soft.training.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.sql.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.v2soft.training.datamodel.AddressTypeMod;
import com.v2soft.training.datamodel.EmployeeAddressIdMod;
import com.v2soft.training.datamodel.EmployeeAddressMod;
import com.v2soft.training.datamodel.EmployeeBasicInfo;
import com.v2soft.training.datamodel.EmployeeMod;
import com.v2soft.training.datamodel.LoginCredentials;
import com.v2soft.training.datamodel.ValidateUser;
import com.v2soft.training.filter.AddResponseHeaderFilter;
import com.v2soft.training.model.AddressType;
import com.v2soft.training.model.Employee;
import com.v2soft.training.model.EmployeeAddress;
import com.v2soft.training.model.EmployeeLogin;
import com.v2soft.training.model.EmployeeLoginId;
import com.v2soft.training.model.LoginSession;
import com.v2soft.training.model.LoginSessionId;

public class EmployeeDaoImpl implements EmployeeDao {
	
	//@Autowired
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    //SELECT * FROM employee_info;
    /**
	//HQL VERSION
	Query query = getCurrentSession().createQuery("from Employee");
	query.setFirstResult(0 * 4);
	query.setMaxResults(4);
	return query.list();
	**/
	@Transactional
    public List<EmployeeMod> getEmployeeList() {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(root);
		Query<Employee> q = getCurrentSession().createQuery(query);
		//q.setFirstResult(0 * 4);
		//q.setMaxResults(4);
		
		return convertEmployeeListToEmployeeModList(q.getResultList());
    }
	
	/*SELECT * FROM employee_address ea WHERE ea.employee_id="222"
	AND ea.address_type_id=(
		SELECT id FROM address_type at WHERE at.type="current"
	);*/
	/**
	//HQL VERSION
	Query<AddressType> subquery = getCurrentSession().createQuery("from AddressType where type='" + address_type + "'");
	AddressType at = subquery.getSingleResult();
	
	Query<EmployeeAddress> query = 
			getCurrentSession().createQuery(
					"from EmployeeAddress where id.employeeId='" + employee_id + "' and addressType.id='" + at.getId() + "'");
	return query.getResultList();
	**/
	@Transactional
	//@JsonIgnore
    public EmployeeAddressMod getEmployeeAddressByIdAndType(String address_type, String employee_id) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		
		//Subquery to capture addresstype id
		CriteriaQuery<AddressType> subquery = builder.createQuery(AddressType.class);
		Root<AddressType> subroot = subquery.from(AddressType.class);
		subquery.select(subroot).where(builder.equal(subroot.get("type"), address_type));
		Query<AddressType> subq = getCurrentSession().createQuery(subquery);
		AddressType at = subq.getSingleResult();
		
		//Query to use id from subquery and employeeid to receive address
		CriteriaQuery<EmployeeAddress> query = builder.createQuery(EmployeeAddress.class);
		Root<EmployeeAddress> root = query.from(EmployeeAddress.class);
		query.where(
				builder.and(
				builder.equal(root.get("id").get("employeeId"), employee_id)),
				builder.equal(root.get("id").get("addressTypeId"), at.getId())
		);
		Query<EmployeeAddress> q = getCurrentSession().createQuery(query);
		
		EmployeeAddress employeeAddress = q.getSingleResult();
		EmployeeAddressMod empAddress = new EmployeeAddressMod();
		
		AddressTypeMod atm = new AddressTypeMod();
		atm.setId(employeeAddress.getAddressType().getId());
		atm.setType(employeeAddress.getAddressType().getType());
		
		EmployeeAddressIdMod eai = new EmployeeAddressIdMod();
		eai.setAddressTypeId(employeeAddress.getId().getAddressTypeId());
		eai.setEmployeeId(employeeAddress.getId().getEmployeeId());
		
		empAddress.setId(eai);
		empAddress.setAddressType(atm);
		empAddress.setAddressLineOne(employeeAddress.getAddressLineOne());
		empAddress.setAddressLineTwo(employeeAddress.getAddressLineTwo());
		empAddress.setCity(employeeAddress.getCity());
		empAddress.setState(employeeAddress.getState());
		empAddress.setZipcode(employeeAddress.getZipcode());
		empAddress.setZipfour(employeeAddress.getZipfour());
		
		return empAddress;
    }
	
	@Transactional
    public List<Object> getEmployeeInfoByColumns(String[] columns) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Object> query = builder.createQuery(Object.class);
		Root<Employee> root = query.from(Employee.class);
		
		List<Selection<?>> s = new LinkedList<Selection<?>>();
		for(int i = 0; i < columns.length; i++) {
		    s.add(root.get(columns[i]));
		}
		query.multiselect(s);
		Query<Object> q = getCurrentSession().createQuery(query);
		return q.getResultList();
    }
	
	@Transactional
	public Long countEmployees() {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(builder.count(root));
		Query<Long> q = getCurrentSession().createQuery(query);
		return q.getSingleResult();
	}
	
	@Transactional
	public EmployeeMod getEmployeeById(String employeeId) {
		EmployeeMod employeeMod = new EmployeeMod();
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(root).where(builder.equal(root.get("employeeId"), employeeId));
		Query<Employee> q = getCurrentSession().createQuery(query);
        Employee emp = q.getSingleResult();
        
        employeeMod.setEmployeeId(emp.getEmployeeId());
        employeeMod.setFirstName(emp.getFirstName());
        employeeMod.setLastName(emp.getLastName());
        employeeMod.setMiddleName(emp.getMiddleName());
        employeeMod.setDateOfBirth(emp.getDateOfBirth());
        employeeMod.setPassportNumber(emp.getPassportNumber());
        employeeMod.setSsn(emp.getSsn());
        Set<EmployeeAddressMod> employeeAddresses = new HashSet<EmployeeAddressMod>();
        
        for(EmployeeAddress empAddress:emp.getEmployeeAddresses()) {
        	EmployeeAddressMod employeeAddressInfo = new EmployeeAddressMod();
        	
        	AddressTypeMod AddressTypeInfo = new AddressTypeMod();
        	AddressTypeInfo.setId(empAddress.getAddressType().getId());
        	AddressTypeInfo.setType(empAddress.getAddressType().getType());
        	
        	EmployeeAddressIdMod employeeAddressIdInfo = new EmployeeAddressIdMod();
        	employeeAddressIdInfo.setAddressTypeId(empAddress.getId().getAddressTypeId());
        	employeeAddressIdInfo.setEmployeeId(empAddress.getId().getEmployeeId());
        	
        	employeeAddressInfo.setId(employeeAddressIdInfo);
        	employeeAddressInfo.setAddressType(AddressTypeInfo);
        	employeeAddressInfo.setAddressLineOne(empAddress.getAddressLineOne());
        	employeeAddressInfo.setAddressLineTwo(empAddress.getAddressLineTwo());
        	employeeAddressInfo.setCity(empAddress.getCity());
        	employeeAddressInfo.setState(empAddress.getState());
        	employeeAddressInfo.setZipcode(empAddress.getZipcode());
        	employeeAddressInfo.setZipfour(empAddress.getZipfour());
        	employeeAddresses.add(employeeAddressInfo);
        }
        
        employeeMod.setEmployeeAddresses(employeeAddresses);
		return employeeMod;
	}
	
	@Transactional
	public ValidateUser validateUser(LoginCredentials login) {
		String username = login.getUsername();
		String password = login.getPassword();
		boolean validated = false;
		EmployeeLogin empLoginSess = null;
		
		Query<EmployeeLogin> subquery = getCurrentSession().createQuery("from EmployeeLogin");
		List<EmployeeLogin> emplogins = subquery.getResultList();
		Employee emp = null;
		
		for(EmployeeLogin emplogin: emplogins) {
			if(emplogin.getId().getUsername().equals(username)) {
				if(emplogin.getPassword().equals(password)) {
					emp = emplogin.getEmployeeInfo();
					validated = true;
					empLoginSess = emplogin;
				}
			}
		}
		
		EmployeeMod employeeMod = new EmployeeMod();
		ValidateUser user = new ValidateUser();
		
		if(validated && emp != null) {
			employeeMod.setEmployeeId(emp.getEmployeeId());
	        employeeMod.setFirstName(emp.getFirstName());
	        employeeMod.setLastName(emp.getLastName());
	        employeeMod.setMiddleName(emp.getMiddleName());
	        employeeMod.setDateOfBirth(emp.getDateOfBirth());
	        employeeMod.setPassportNumber(emp.getPassportNumber());
	        employeeMod.setSsn(emp.getSsn());
	        Set<EmployeeAddressMod> employeeAddresses = new HashSet<EmployeeAddressMod>();
	        
	        for(EmployeeAddress empAddress:emp.getEmployeeAddresses()) {
	        	EmployeeAddressMod employeeAddressInfo = new EmployeeAddressMod();
	        	
	        	AddressTypeMod AddressTypeInfo = new AddressTypeMod();
	        	AddressTypeInfo.setId(empAddress.getAddressType().getId());
	        	AddressTypeInfo.setType(empAddress.getAddressType().getType());
	        	
	        	EmployeeAddressIdMod employeeAddressIdInfo = new EmployeeAddressIdMod();
	        	employeeAddressIdInfo.setAddressTypeId(empAddress.getId().getAddressTypeId());
	        	employeeAddressIdInfo.setEmployeeId(empAddress.getId().getEmployeeId());
	        	
	        	employeeAddressInfo.setId(employeeAddressIdInfo);
	        	employeeAddressInfo.setAddressType(AddressTypeInfo);
	        	employeeAddressInfo.setAddressLineOne(empAddress.getAddressLineOne());
	        	employeeAddressInfo.setAddressLineTwo(empAddress.getAddressLineTwo());
	        	employeeAddressInfo.setCity(empAddress.getCity());
	        	employeeAddressInfo.setState(empAddress.getState());
	        	employeeAddressInfo.setZipcode(empAddress.getZipcode());
	        	employeeAddressInfo.setZipfour(empAddress.getZipfour());
	        	employeeAddresses.add(employeeAddressInfo);
	        }
	        
	        employeeMod.setEmployeeAddresses(employeeAddresses);
	        
	        //Add session to table
	        UUID uuid = UUID.randomUUID();
	        LoginSessionId lsi = new LoginSessionId();
	        lsi.setEmployeeId(employeeMod.getEmployeeId());
	        lsi.setUsername(username);
	        lsi.setLoginSessionId(uuid.toString());
	        
	        Date datetimeNow = new Date(Calendar.getInstance().getTime().getTime());
	        
	        LoginSession sess = new LoginSession();
	        sess.setId(lsi);
	        sess.setEmployeeLogin(empLoginSess);
	        sess.setCreatedBy("system");
	        sess.setCreatedByTime(datetimeNow);
	        sess.setUpdatedBy("system");
	        sess.setLoginTime(datetimeNow);
	        sess.setStatus("A");
	        
	        getCurrentSession().persist(sess);
	        
	        user.setEmp(employeeMod);
	        user.setUuid(uuid);
	        
	        //AddResponseHeaderFilter.setHeaderLoginSession(uuid.toString());
		}
		
		return user;
	}
	
	@Transactional
	public List<EmployeeMod> searchEmployee(EmployeeBasicInfo emp) {
		List<LoginCredentials> oldListAttributes = new ArrayList<LoginCredentials>();
		oldListAttributes.add(new LoginCredentials("employeeId", emp.getEmployeeId()));
		oldListAttributes.add(new LoginCredentials("dateOfBirth", emp.getDateOfBirth().toString()));
		oldListAttributes.add(new LoginCredentials("firstName", emp.getFirstName()));
		oldListAttributes.add(new LoginCredentials("lastName", emp.getLastName()));
		oldListAttributes.add(new LoginCredentials("middleName", emp.getMiddleName()));
		oldListAttributes.add(new LoginCredentials("passportNumber", emp.getPassportNumber()));
		oldListAttributes.add(new LoginCredentials("ssn", emp.getSsn()));
		
		System.out.println("OLD SIZE: " + oldListAttributes.size());
		
		List<LoginCredentials> newListAttributes = new ArrayList<LoginCredentials>();
		
		for(LoginCredentials lc: oldListAttributes) {
			if(lc.getPassword() != null && !lc.getPassword().isEmpty())
				newListAttributes.add(lc);
		}
		
		String createQuery = "from Employee WHERE ";
		for(int i = 0; i < newListAttributes.size(); i++) {
			LoginCredentials lc = newListAttributes.get(i);
			if(i < newListAttributes.size()-1)
				createQuery += lc.getUsername() + "='" + lc.getPassword() + "' AND ";
			else
				createQuery += lc.getUsername() + "='" + lc.getPassword() + "'";
		}
		
		Query<Employee> query = getCurrentSession().createQuery(createQuery);
		
		return convertEmployeeListToEmployeeModList(query.getResultList());
	}
	
	//SELECT status FROM login_session WHERE login_session_id='035e6d85-eb0c-4446-b41b-c5a7cad8adfa';
	@Transactional
	public boolean checkLoginSession(String loginSessionId) {
		String createQuery = "select from LoginSession where id.loginSessionId='" + loginSessionId + "'";
		Query<LoginSession> query = getCurrentSession().createQuery(createQuery);
		LoginSession loginSession = query.uniqueResult();
		if(loginSession.getStatus().equals("A"))
			return true;
		return false;
	}
	
	@Transactional
	public void performLogout(String loginSessionId) {
		String createQuery = "from LoginSession";
	    Query<LoginSession> query = getCurrentSession().createQuery(createQuery);
	    List<LoginSession> loginSession = query.getResultList();
	    
	    for(LoginSession loginSess: loginSession) {
	        if(loginSessionId.equals(loginSess.getId().getLoginSessionId())) {
	    	    if(loginSess.getStatus().equals("A")) {
	    			LoginSession logoutSession = (LoginSession)getCurrentSession().createQuery(createQuery).uniqueResult();
	    			if(loginSessionId.equals(logoutSession.getId().getLoginSessionId())) {
	    				Date now = new Date(Calendar.getInstance().getTime().getTime());
	    				logoutSession.setStatus("T");
	    				logoutSession.setLogoutTime(now);
	    			}
	    			
	    		} else {
	    			System.out.println("SESSION IS ALREADY TERMINATED");
	    		}
	        }
	        break;
	    }
	}
	
	private List<EmployeeMod> convertEmployeeListToEmployeeModList(List<Employee> empList) {
		List<EmployeeMod> employeeModList = new ArrayList<EmployeeMod>();
		
		for(int i = 0; i < empList.size(); i++) {
			EmployeeMod mod = new EmployeeMod();
			Employee tmp = empList.get(i);
			
			mod.setEmployeeId(tmp.getEmployeeId());
			mod.setFirstName(tmp.getFirstName());
			mod.setLastName(tmp.getLastName());
			mod.setMiddleName(tmp.getMiddleName());
			mod.setDateOfBirth(tmp.getDateOfBirth());
			mod.setPassportNumber(tmp.getPassportNumber());
			mod.setSsn(tmp.getSsn());
			
			Set<EmployeeAddressMod> empAddressMod = new HashSet<EmployeeAddressMod>();
			for(EmployeeAddress empAddress: tmp.getEmployeeAddresses()) {
				EmployeeAddressMod eam = new EmployeeAddressMod();
				
				EmployeeAddressIdMod eai = new EmployeeAddressIdMod();
				eai.setAddressTypeId(empAddress.getAddressType().getId());
				eai.setEmployeeId(empAddress.getEmployeeInfo().getEmployeeId());
				
				AddressTypeMod atm = new AddressTypeMod();
				atm.setId(empAddress.getAddressType().getId());
				atm.setType(empAddress.getAddressType().getType());
				
				eam.setId(eai);
				eam.setAddressType(atm);
				eam.setAddressLineOne(empAddress.getAddressLineOne());
				eam.setAddressLineTwo(empAddress.getAddressLineTwo());
				eam.setCity(empAddress.getCity());
				eam.setState(empAddress.getState());
				eam.setZipcode(empAddress.getZipcode());
				eam.setZipfour(empAddress.getZipfour());
				
				empAddressMod.add(eam);
			}
			mod.setEmployeeAddresses(empAddressMod);
			employeeModList.add(mod);
		}
		
		return employeeModList;
	}
}
