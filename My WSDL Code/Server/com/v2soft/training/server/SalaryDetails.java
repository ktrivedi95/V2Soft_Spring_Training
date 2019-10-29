
package com.v2soft.training.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SalaryDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SalaryDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BasicPay" type="{http://localhost:8080/types}String20"/&gt;
 *         &lt;element name="HRA" type="{http://localhost:8080/types}String20"/&gt;
 *         &lt;element name="TravelAllowance" type="{http://localhost:8080/types}String20"/&gt;
 *         &lt;element name="MedicalAllowance" type="{http://localhost:8080/types}String20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalaryDetails", propOrder = {
    "basicPay",
    "hra",
    "travelAllowance",
    "medicalAllowance"
})
public class SalaryDetails {

    @XmlElement(name = "BasicPay", required = true)
    protected String basicPay;
    @XmlElement(name = "HRA", required = true)
    protected String hra;
    @XmlElement(name = "TravelAllowance", required = true)
    protected String travelAllowance;
    @XmlElement(name = "MedicalAllowance", required = true)
    protected String medicalAllowance;

    /**
     * Gets the value of the basicPay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasicPay() {
        return basicPay;
    }

    /**
     * Sets the value of the basicPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasicPay(String value) {
        this.basicPay = value;
    }

    /**
     * Gets the value of the hra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHRA() {
        return hra;
    }

    /**
     * Sets the value of the hra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHRA(String value) {
        this.hra = value;
    }

    /**
     * Gets the value of the travelAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelAllowance() {
        return travelAllowance;
    }

    /**
     * Sets the value of the travelAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelAllowance(String value) {
        this.travelAllowance = value;
    }

    /**
     * Gets the value of the medicalAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalAllowance() {
        return medicalAllowance;
    }

    /**
     * Sets the value of the medicalAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalAllowance(String value) {
        this.medicalAllowance = value;
    }

}
