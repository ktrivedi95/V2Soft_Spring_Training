package com.v2soft.training.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.4
 * 2019-10-29T11:06:06.408-04:00
 * Generated source version: 3.3.4
 *
 */
@WebService(targetNamespace = "http://localhost:8080", name = "EmployeeForHr")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EmployeeForHr {

    @WebMethod
    @WebResult(name = "CreateEmployeeResponse", targetNamespace = "http://localhost:8080/types", partName = "out")
    public EmployeeWithoutSalary createEmployee(

        @WebParam(partName = "in", name = "CreateEmployeeRequest", targetNamespace = "http://localhost:8080/types")
        CreateEmployeeRequestWithSecurity in
    );
}
