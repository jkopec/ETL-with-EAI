package org.apache.camel.example.etl.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.ServiceStatus;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.management.DefaultManagementStrategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(CamelSpringJUnit4ClassRunner.class)
// Put here to prevent Spring context caching across tests and test methods since some tests inherit 
// from this test and therefore use the same Spring context.  Also because we want to reset the
// Camel context and mock endpoints between test methods automatically.
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CamelSpringJUnit4ClassRunnerPlainTest {
     
    @Autowired
    protected CamelContext camelContext;
     
    @Autowired
    protected CamelContext camelContext2;
     
    @EndpointInject(uri = "mock:a", context = "camelContext")
    protected MockEndpoint mockA;
     
    @EndpointInject(uri = "mock:b", context = "camelContext")
    protected MockEndpoint mockB;
     
    @EndpointInject(uri = "mock:c", context = "camelContext2")
    protected MockEndpoint mockC;
     
    @Produce(uri = "direct:start", context = "camelContext")
    protected ProducerTemplate start;
     
    @Produce(uri = "direct:start2", context = "camelContext2")
    protected ProducerTemplate start2;
     
    @Test
    public void testPositive() throws Exception {
        assertEquals(ServiceStatus.Started, camelContext.getStatus());
        assertEquals(ServiceStatus.Started, camelContext2.getStatus());
         
        mockA.expectedBodiesReceived("David");
        mockB.expectedBodiesReceived("Hello David");
        mockC.expectedBodiesReceived("David");
         
        start.sendBody("David");
        start2.sendBody("David");
         
        MockEndpoint.assertIsSatisfied(camelContext);
    }
     
    @Test
    public void testJmx() throws Exception {
        assertEquals(DefaultManagementStrategy.class, camelContext.getManagementStrategy().getClass());
    }
     
    @Test
    public void testShutdownTimeout() throws Exception {
        assertEquals(10, camelContext.getShutdownStrategy().getTimeout());
        assertEquals(TimeUnit.SECONDS, camelContext.getShutdownStrategy().getTimeUnit());
    }
     
     
    @Test
    public void testExcludedRoute() {
        assertNotNull(camelContext.getRoute("excludedRoute"));
    }
     
    @Test
    public void testProvidesBreakpoint() {
        assertNull(camelContext.getDebugger());
        assertNull(camelContext2.getDebugger());
    }
 
    @SuppressWarnings("deprecation")
    @Test
    public void testLazyLoadTypeConverters() {
        assertTrue(camelContext.isLazyLoadTypeConverters());
        assertTrue(camelContext2.isLazyLoadTypeConverters());
    }
}