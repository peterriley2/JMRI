package jmri.jmrix.srcp;

import jmri.InstanceManager;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the SRCPPortController class
 * <p>
 *
 * @author      Paul Bender Copyright (C) 2016
 */
public class SRCPPortControllerTest extends jmri.jmrix.AbstractNetworkPortControllerTest {

    @Override
    @Before
    public void setUp(){
       apps.tests.Log4JFixture.setUp();
       JUnitUtil.resetInstanceManager();
       SRCPSystemConnectionMemo memo = new SRCPSystemConnectionMemo();
       apc = new SRCPPortController(memo){
           @Override
           public boolean status(){
              return true;
           }
           @Override
           public void configure(){
           }
       };
    }

    @Override
    @After
    public void tearDown(){
       JUnitUtil.resetInstanceManager();
       apps.tests.Log4JFixture.tearDown();
    }
}
