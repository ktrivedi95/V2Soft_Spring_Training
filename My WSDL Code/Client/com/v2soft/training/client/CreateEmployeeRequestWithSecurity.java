
package com.v2soft.training.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateEmployeeRequestWithSecurity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateEmployeeRequestWithSecurity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SecurityCredentials" type="{http://localhost:8080/types}SecurityInformation"/&gt;
 *         &lt;element name="EmployeeWithoutSalary" type="{http://localhost:8080/types}EmployeeWithoutSalary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateEmployeeRequestWithSecurity", propOrder = {
    "securityCredentials",
    "employeeWithoutSalary"
})
public class CreateEmployeeRequestWithSecurity {

    @XmlElement(name = "SecurityCredentials", required = true)
    protected SecurityInformation securityCredentials;
    @XmlElement(name = "EmployeeWithoutSalary", required = true)
    protected EmployeeWithoutSalary employeeWithoutSalary;

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
     * Gets the value of the employeeWithoutSalary property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeWithoutSalary }
     *     
     */
    public EmployeeWithoutSalary getEmployeeWithoutSalary() {
        return employeeWithoutSalary;
    }

    /**
     * Sets the value of the employeeWithoutSalary property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeWithoutSalary }
     *     
     */
    public void setEmployeeWithoutSalary(EmployeeWithoutSalary value) {
        this.employeeWithoutSalary = value;
    }

}
