package jmri.jmrix.powerline;

import jmri.Sensor;
import jmri.SensorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the SerialSensorManager class.
 *
 * @author	Bob Jacobsen Copyright 2003, 2007, 2008 Converted to multiple
 * connection
 * @author kcameron Copyright (C) 2011
 * @author      Paul Bender Copyright (C) 2016
 */
public class SerialSensorManagerTest extends jmri.managers.AbstractSensorMgrTest {
    @Override
    public String getSystemName(int i) {
        return "PSP" + i;
    }

    @Test
    public void testSensorCreationAndRegistration() {
        l.provideSensor("PSA3");

        l.provideSensor("PSA11");

        l.provideSensor("PSP8");

        l.provideSensor("PSP9");

        l.provideSensor("PSK13");

        l.provideSensor("PSJ6");

        l.provideSensor("PSA15");

        l.provideSensor("PSB5");

        l.provideSensor("PSH7");

        l.provideSensor("PSI7");

        l.provideSensor("PSJ7");
    }

    @Override
    @Test
    public void testDefaultSystemName() {
        // create
        // powerline systems require a module letter(?) which
        // isn't provided by makeSystemName();      
        Sensor t = l.provideSensor("PSP" + getNumToTest1());
        // check
        Assert.assertTrue("real object returned ", t != null);
        Assert.assertTrue("system name correct ", t == l.getBySystemName(getSystemName(getNumToTest1())));
    }

    @Override
    @Test
    public void testUpperLower() {
        // powerline systems require a module letter(?) which
        // isn't provided by makeSystemName();      
        Sensor t = l.provideSensor("PSP" + getNumToTest1());
        String name = t.getSystemName();
        Assert.assertNull(l.getSensor(name.toLowerCase()));
    }

    // The minimal setup for log4J
    @Override
    @Before
    public void setUp() {
        apps.tests.Log4JFixture.setUp();
        jmri.util.JUnitUtil.resetInstanceManager();
        // replace the SerialTrafficController to get clean reset
        SerialTrafficController t = new jmri.jmrix.powerline.SerialTrafficController() {
            SerialTrafficController test() {
                return this;
            }
        }.test();
        Assert.assertNotNull("exists", t);

        SerialSystemConnectionMemo m = new SerialSystemConnectionMemo();

        m.setSerialAddress(new SerialAddress(m));

        t.setAdapterMemo(m);

        l = new SerialSensorManager(t) {
            public void reply(SerialReply r) {
            }
        };
    }

    @After
    public void tearDown() {
        l.dispose();
        jmri.util.JUnitUtil.resetInstanceManager();
        apps.tests.Log4JFixture.tearDown();
    }


}
