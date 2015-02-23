/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.etl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ein Beispiel für eine Entität welche von oder zu einem 
 * XML Dokument umgewandelt werden kann
 */
@Entity(name = "customer")
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "findCustomerByUsername", query = "SELECT c FROM customer c WHERE c.userName = :userName")
public class CustomerEntity {
    @XmlAttribute
    private Long id;
    private String userName;
    private String firstName;
    private String surname;
    private String street;
    private String city;
    private String zip;
    private String phone;

    @Id
    @GeneratedValue
    /**
     * Gibt die id zurueck.
     * @return die id
     */
    public Long getId() {
        return id;
    }
    /**
     * Setzt die id.
     * @param id die id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Gibt die Stadt zurueck.
     * @return die Stadt
     */
    public String getCity() {
        return city;
    }
    /**
     * Setzt die Stadt.
     * @param city die Stadt
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Gibt den Vornamen zurueck.
     * @return den Vornamen
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Setzt den Vornamen.
     * @param firstName der Vorname
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gibt die Telefonnummer zurueck.
     * @return die Telefonnummer
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Setzt die Telefonnummer.
     * @param phone die Telefonnummer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Gibt die Straße zurueck.
     * @return die Straße
     */
    public String getStreet() {
        return street;
    }
    /**
     * Setzt die Straße.
     * @param street die Straße.
     */
    public void setStreet(String street) {
        this.street = street;
    }
    /**
     * Gibt den Nachnamen zurueck.
     * @return den Nachnamen
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Setzt den Nachnamen.
     * @param surname den Nachnamen
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Gibt den Usernamen zurueck.
     * @return den Usernamen
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Setzt den Usernamen
     * @param userName der Username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Gibt die Postleitzahl zurueck.
     * @return die Postleitzahl
     */
    public String getZip() {
        return zip;
    }
    /**
     * Setzt die Postleitzahl.
     * @param zip die Postleitzahl
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    
   /**
    * Diese Methode wandelt den Benutzer in einen String um und gibt diesen zurueck.
    */
    public String toString() {
        return "Customer[userName: " + getUserName() + " firstName: " + getFirstName() + " surname: " + getSurname() + "]";
    }

}