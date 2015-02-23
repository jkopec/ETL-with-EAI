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
package org.apache.camel.example.etl.test;

import junit.framework.TestCase;
import org.apache.camel.spring.Main;

/**
 * Dieser Test soll das Programm starten und eine gewisse Zeit laufen
 * lassen um sicher zu gehen, dass die Applikation funktioniert.
 * @version 3
 */
public class IntegrationTest extends TestCase {
    public void testEtlRoutes() throws Exception {
        // let's boot up the Spring application context for 5 seconds to check that it works OK
        Main.main("-duration", "5s", "-o", "target/site/cameldoc");
    }
}