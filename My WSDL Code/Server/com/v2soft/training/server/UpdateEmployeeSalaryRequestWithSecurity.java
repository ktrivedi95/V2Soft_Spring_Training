
package com.v2soft.training.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateEmployeeSalaryRequestWithSecurity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateEmployeeSalaryRequestWithSecurity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SecurityCredentials" type="{http://localhost:8080/types}SecurityInformation"/&gt;
 *         &lt;element name="EmployeeWithSalary" type="{http://localhost:8080/types}EmployeeWithSalary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateEmployeeSalaryRequestWithSecurity", propOrder = {
    "securityCredentials",
    "employeeWithSalary"
})
public class UpdateEmployeeSalaryRequestWithSecurity {

    @XmlElement(name = "SecurityCredentials", required = true)
    protected SecurityInformation securityCredentials;
    @XmlElement(name = "EmployeeWithSalary", required = true)
    protected EmployeeWithSalary employeeWithSalary;

    /**
     * Gets the value of the securityCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityInformation }
     *     
     */
    public SecurityInformation getSecurityCredentials() {
        return securityCredentials;
    }

    /**
     * Sets the value of the securityCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityInformation }
     *     
     */
    public void setSecurityCredentials(SecurityInformation value) {
        this.securityCredentials = value;
    }

    /**
     * Gets the value of the employeeWithSalary property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeWithSalary }
     *     
     */
    public EmployeeWithSalary getEmployeeWithSalary() {
        return employeeWithSalary;
    }

    /**
     * Sets the value of the employeeWithSalary property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeWithSalary }
     *     
     */
    public void setEmployeeWithSalary(EmployeeWithSalary value) {
        this.employeeWithSalary = value;
    }

}
