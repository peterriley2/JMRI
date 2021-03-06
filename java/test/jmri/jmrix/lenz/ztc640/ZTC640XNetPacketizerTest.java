package jmri.jmrix.lenz.ztc640;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;


/**
 * <p>
 * Title: ZTC640XNetPacketizerTest </p>
 * <p>
 *
 * @author Paul Bender Copyright (C) 2009
 */
public class ZTC640XNetPacketizerTest extends jmri.jmrix.lenz.XNetPacketizerTest {

    // The minimal setup for log4J
    @Before
    @Override
    public void setUp() {
        apps.tests.Log4JFixture.setUp();
        tc = new ZTC640XNetPacketizer(new jmri.jmrix.lenz.LenzCommandStation());
    }

    @After
    @Override
    public void tearDown() {
        tc = null;
        apps.tests.Log4JFixture.tearDown();
    }

}
