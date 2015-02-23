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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ein PersonDocument welches aus XML-Files in weiterer Folge
 * in CutomerEntitys umgewandelt werden kann.
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDocument {
    @XmlAttribute
    private String user;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    private String city;

    @Override
    /**
     * Diese Methode wandelt den Benutzer in einen String um und gibt diesen zurueck.
     */
    public String toString() {
        return "Person[user: " + user + "]";
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
     * Gibt den Nachnamen zurueck.
     * @return den Nachnamen
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Setzt den Nachnamen.
     * @param lastName den Nachnamen
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Gibt den Usernamen zurueck.
     * @return den Usernamen
     */
    public String getUser() {
        return user;
    }
    /**
     * Setzt den Usernamen
     * @param user der Username
     */
    public void setUser(String user) {
        this.user = user;
    }
}