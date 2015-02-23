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

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.component.jpa.JpaConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * A Message Transformer of an XML document to a Customer entity bean
 * 
 * @version 
 */
// START SNIPPET: example
@Converter
public final class CustomerTransformer {
	//Logger erstellen und initialisieren 
    private static final Logger LOG = LoggerFactory.getLogger(CustomerTransformer.class);

    /**
     * Konvertiert die gepollten Informationen aus den XML-Files, von einem 
     * PersonDocument in einen Datenbankeintrag als CustomerEntity.
     */
    @Converter
    public static CustomerEntity toCustomer(PersonDocument doc, Exchange exchange) throws Exception {
    	//EntityManager wird erstellt und mit Informationen des Exchange initialisiert (beispielsweise: id)  Exchange-Pattern!
        EntityManager entityManager = exchange.getProperty(JpaConstants.ENTITY_MANAGER, EntityManager.class);
        TransactionTemplate transactionTemplate = exchange.getContext().getRegistry().lookupByNameAndType("transactionTemplate", TransactionTemplate.class);
        
        //Username wird aus dem PersonalDocument ausgewertet
        String user = doc.getUser();
        //Erstellen einer CustomerEntity und Initialisierung falls es in der Datenbank einen 
        //Eintrag gibt welcher mit dem ausgelesenen usernamen übereinstimmt
        CustomerEntity customer = findCustomerByName(transactionTemplate, entityManager, user);

        //Daten aus dem PersonalDocument nun in CustomEntity speichern
        customer.setUserName(user);
        customer.setFirstName(doc.getFirstName());
        customer.setSurname(doc.getLastName());
        customer.setCity(doc.getCity());
        
        //Wenn erfolgreich loggen und das CustomEntity-Objekt zurueckgeben
        LOG.info("Created object customer: {}", customer);
        return customer;
    }

    /**
     * Diese Methode wird in der obigen verwendet und durchforstet die Datenbank nach einem 
     * bestimmten Benutzereintrag welchen sie dann zurueckgibt. Falls es keinen gueltigen Eintrag
     * zu den gewünschten Suchkriterien gibt, wird ein neues CustomerEntity-Objekt zurueckgegeben.
     */
    private static CustomerEntity findCustomerByName(TransactionTemplate transactionTemplate, final EntityManager entityManager, final String userName) throws Exception {
        return transactionTemplate.execute(new TransactionCallback<CustomerEntity>() {
            public CustomerEntity doInTransaction(TransactionStatus status) {
                entityManager.joinTransaction();
                //Liste fuer die Ergebnisse wird erstellt
                List<CustomerEntity> list = entityManager.createNamedQuery("findCustomerByUsername", CustomerEntity.class).setParameter("userName", userName).getResultList();
                CustomerEntity answer;
                //Wenn es keinen Eintrag zu den gewuenschten Suchkriterien gibt...
                if (list.isEmpty()) {
                    answer = new CustomerEntity(); //Wird ein neues CustomerEntity-Objek erzeugt
                    answer.setUserName(userName); //Wird mit einem default Usernamen initialisiert
                    LOG.info("Created a new CustomerEntity {} as no matching persisted entity found.", answer);
                } else { //Ansonsten...
                    answer = list.get(0);//Wird der erste Eintrag in der Liste zurueckgegeben
                    LOG.info("Found a matching CustomerEntity {} having the userName {}.", answer, userName);
                }

                return answer;
            }
        });
    }

}
// END SNIPPET: example