
package com.v2soft.training.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EmployeeWithSalary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EmployeeWithSalary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FirstName" type="{http://localhost:8080/types}String30"/&gt;
 *         &lt;element name="LastName" type="{http://localhost:8080/types}String30"/&gt;
 *         &lt;element name="DateOfBirth" type="{http://localhost:8080/types}String10"/&gt;
 *         &lt;element name="EmployeeId" type="{http://localhost:8080/types}String10" minOccurs="0"/&gt;
 *         &lt;element name="EmployeeSalaryDetails" type="{http://localhost:8080/types}SalaryDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmployeeWithSalary", propOrder = {
    "firstName",
    "lastName",
    "dateOfBirth",
    "employeeId",
    "employeeSalaryDetails"
})
public class EmployeeWithSalary {

    @XmlElement(name = "FirstName", required = true)
    protected String firstName;
    @XmlElement(name = "LastName", required = true)
    protected String lastName;
    @XmlElement(name = "DateOfBirth", required = true)
    protected String dateOfBirth;
    @XmlElement(name = "EmployeeId")
    protected String employeeId;
    @XmlElement(name = "EmployeeSalaryDetails", required = true)
    protected SalaryDetails employeeSalaryDetails;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the employeeSalaryDetails property.
     * 
     * @return
     *     possible object is
     *     {@link SalaryDetails }
     *     
     */
    public SalaryDetails getEmployeeSalaryDetails() {
        return employeeSalaryDetails;
    }

    /**
     * Sets the value of the employeeSalaryDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalaryDetails }
     *     
     */
    public void setEmployeeSalaryDetails(SalaryDetails value) {
        this.employeeSalaryDetails = value;
    }

}
