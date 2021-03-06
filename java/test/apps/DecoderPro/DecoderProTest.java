package apps.DecoderPro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * Description: Tests for the DecoderPro application.
 *
 * @author  Paul Bender Copyright (C) 2016
 */
public class DecoderProTest {

    @Test
    @Ignore("This test works, but actually starts DecoderPro")
    public void testCtor() {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        apps.Apps a = new DecoderPro(frame);
        Assert.assertNotNull(a);
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
