package jmri.jmrix.mrc;

import jmri.InstanceManager;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the MrcTrafficController class
 * <p>
 *
 * @author      Paul Bender Copyright (C) 2016
 */
public class MrcTrafficControllerTest {

    private MrcTrafficController tc = null;

    @Test
    public void testCtor(){
       Assert.assertNotNull("exists",tc);
    }

    @Before
    public void setUp(){
       apps.tests.Log4JFixture.setUp();
       JUnitUtil.resetInstanceManager();
       tc = new MrcTrafficController(){
          @Override
          public boolean status() { return true; }
          @Override
          public void sendMrcMessage(MrcMessage m) {}
          @Override
          public boolean isXmtBusy() { return false; }
       };
    }

    @After
    public void tearDown(){
       JUnitUtil.resetInstanceManager();
       apps.tests.Log4JFixture.tearDown();
    }

}
