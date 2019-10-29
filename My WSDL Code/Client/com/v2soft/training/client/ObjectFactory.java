
package com.v2soft.training.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.v2soft.training.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateEmployeeRequest_QNAME = new QName("http://localhost:8080/types", "CreateEmployeeRequest");
    private final static QName _CreateEmployeeResponse_QNAME = new QName("http://localhost:8080/types", "CreateEmployeeResponse");
    private final static QName _UpdateEmployeeSalaryRequest_QNAME = new QName("http://localhost:8080/types", "UpdateEmployeeSalaryRequest");
    private final static QName _UpdateEmployeeSalaryResponse_QNAME = new QName("http://localhost:8080/types", "UpdateEmployeeSalaryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.v2soft.training.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateEmployeeRequestWithSecurity }
     * 
     */
    public CreateEmployeeRequestWithSecurity createCreateEmployeeRequestWithSecurity() {
        return new CreateEmployeeRequestWithSecurity();
    }

    /**
     * Create an instance of {@link EmployeeWithoutSalary }
     * 
     */
    public EmployeeWithoutSalary createEmployeeWithoutSalary() {
        return new EmployeeWithoutSalary();
    }

    /**
     * Create an instance of {@link UpdateEmployeeSalaryRequestWithSecurity }
     * 
     */
    public UpdateEmployeeSalaryRequestWithSecurity createUpdateEmployeeSalaryRequestWithSecurity() {
        return new UpdateEmployeeSalaryRequestWithSecurity();
    }

    /**
     * Create an instance of {@link EmployeeWithSalary }
     * 
     */
    public EmployeeWithSalary createEmployeeWithSalary() {
        return new EmployeeWithSalary();
    }

    /**
     * Create an instance of {@link SecurityInformation }
     * 
     */
    public SecurityInformation createSecurityInformation() {
        return new SecurityInformation();
    }

    /**
     * Create an instance of {@link SalaryDetails }
     * 
     */
    public SalaryDetails createSalaryDetails() {
        return new SalaryDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEmployeeRequestWithSecurity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateEmployeeRequestWithSecurity }{@code >}
     */
    @XmlElementDecl(namespace = "http://localhost:8080/types", name = "CreateEmployeeRequest")
    public JAXBElement<CreateEmployeeRequestWithSecurity> createCreateEmployeeRequest(CreateEmployeeRequestWithSecurity value) {
        return new JAXBElement<CreateEmployeeRequestWithSecurity>(_CreateEmployeeRequest_QNAME, CreateEmployeeRequestWithSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeWithoutSalary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmployeeWithoutSalary }{@code >}
     */
    @XmlElementDecl(namespace = "http://localhost:8080/types", name = "CreateEmployeeResponse")
    public JAXBElement<EmployeeWithoutSalary> createCreateEmployeeResponse(EmployeeWithoutSalary value) {
        return new JAXBElement<EmployeeWithoutSalary>(_CreateEmployeeResponse_QNAME, EmployeeWithoutSalary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeSalaryRequestWithSecurity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeSalaryRequestWithSecurity }{@code >}
     */
    @XmlElementDecl(namespace = "http://localhost:8080/types", name = "UpdateEmployeeSalaryRequest")
    public JAXBElement<UpdateEmployeeSalaryRequestWithSecurity> createUpdateEmployeeSalaryRequest(UpdateEmployeeSalaryRequestWithSecurity value) {
        return new JAXBElement<UpdateEmployeeSalaryRequestWithSecurity>(_UpdateEmployeeSalaryRequest_QNAME, UpdateEmployeeSalaryRequestWithSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeWithSalary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmployeeWithSalary }{@code >}
     */
    @XmlElementDecl(namespace = "http://localhost:8080/types", name = "UpdateEmployeeSalaryResponse")
    public JAXBElement<EmployeeWithSalary> createUpdateEmployeeSalaryResponse(EmployeeWithSalary value) {
        return new JAXBElement<EmployeeWithSalary>(_UpdateEmployeeSalaryResponse_QNAME, EmployeeWithSalary.class, null, value);
    }

}
