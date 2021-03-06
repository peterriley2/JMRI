package jmri.jmrix.mrc.configurexml;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * MrcTurnoutManagerXmlTest.java
 *
 * Description: tests for the MrcTurnoutManagerXml class
 *
 * @author   Paul Bender  Copyright (C) 2016
 */
public class MrcTurnoutManagerXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("MrcTurnoutManagerXml constructor",new MrcTurnoutManagerXml());
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        apps.tests.Log4JFixture.setUp();
    }

    @After
    public void tearDown() {
        apps.tests.Log4JFixture.tearDown();
    }

}

