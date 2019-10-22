package com.v2soft.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2soft.training.dao.EmployeeDao;
import com.v2soft.training.datamodel.EmployeeAddressMod;
import com.v2soft.training.datamodel.EmployeeBasicInfo;
import com.v2soft.training.datamodel.EmployeeMod;
import com.v2soft.training.datamodel.LoginCredentials;
import com.v2soft.training.datamodel.ValidateUser;
import com.v2soft.training.model.Employee;
import com.v2soft.training.model.EmployeeAddress;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
    
	@Transactional
	@Override
    public List<EmployeeMod> getEmployeeList() {
		return employeeDao.getEmployeeList();
    }
	
	@Transactional
	@Override
    public List<EmployeeAddressMod> getEmployeeAddressByIdAndType(String address_type, String employee_id) {
		return new ArrayList<EmployeeAddressMod>();
		//return employeeDao.getEmployeeAddressByIdAndType(address_type, employee_id);
    }
	
	@Transactional
	@Override
    public List<Object> getEmployeeInfoByColumns(String[] columns) {
		return employeeDao.getEmployeeInfoByColumns(columns);
    }
	
	@Transactional
	@Override
	public Long countEmployees() {
		return employeeDao.countEmployees();
	}
	
	@Transactional
	@Override
	public EmployeeMod getEmployeeById(String employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}
	
	@Transactional
	@Override
	public ValidateUser validateUser(LoginCredentials login) {
		return employeeDao.validateUser(login);
	}
	
	@Transactional
	@Override
	public List<EmployeeMod> searchEmployee(EmployeeBasicInfo employeeMod) {
		return employeeDao.searchEmployee(employeeMod);
	}
	
	@Transactional
	@Override
	public boolean checkLoginSession(String loginSessionId) {
		return employeeDao.checkLoginSession(loginSessionId);
	}
	
	@Transactional
	@Override
	public void performLogout(String loginSessionId) {
		employeeDao.performLogout(loginSessionId);
	}
}
