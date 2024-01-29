//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.01.25 at 09:07:21 AM IST 
//


package com.airport.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Airport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Airport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IATACODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="airportname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cityname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Airport", propOrder = {
    "iatacode",
    "airportname",
    "cityname"
})
public class Airport {

    @XmlElement(name = "IATACODE", required = true)
    protected String iatacode;
    @XmlElement(required = true)
    protected String airportname;
    @XmlElement(required = true)
    protected String cityname;

    /**
     * Gets the value of the iatacode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIATACODE() {
        return iatacode;
    }

    /**
     * Sets the value of the iatacode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIATACODE(String value) {
        this.iatacode = value;
    }

    /**
     * Gets the value of the airportname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirportname() {
        return airportname;
    }

    /**
     * Sets the value of the airportname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirportname(String value) {
        this.airportname = value;
    }

    /**
     * Gets the value of the cityname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * Sets the value of the cityname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityname(String value) {
        this.cityname = value;
    }

}