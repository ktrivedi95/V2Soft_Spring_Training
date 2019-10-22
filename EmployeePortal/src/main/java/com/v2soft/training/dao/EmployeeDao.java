package com.v2soft.training.dao;

import java.util.List;

import com.v2soft.training.datamodel.EmployeeAddressMod;
import com.v2soft.training.datamodel.EmployeeBasicInfo;
import com.v2soft.training.datamodel.EmployeeMod;
import com.v2soft.training.datamodel.LoginCredentials;
import com.v2soft.training.datamodel.ValidateUser;

public interface EmployeeDao {
    
	List<EmployeeMod> getEmployeeList();
	
    EmployeeAddressMod getEmployeeAddressByIdAndType(String address_type, String employee_id);
	
    List<Object> getEmployeeInfoByColumns(String[] columns);
	
	Long countEmployees();
	
	EmployeeMod getEmployeeById(String employeeId);
	
	ValidateUser validateUser(LoginCredentials login);
	
	List<EmployeeMod> searchEmployee(EmployeeBasicInfo employeeMod);
	
	boolean checkLoginSession(String loginSessionId);
	
	void performLogout(String loginSessionId);
}
