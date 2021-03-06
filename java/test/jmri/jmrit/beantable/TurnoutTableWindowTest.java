package jmri.jmrit.beantable;

import java.awt.GraphicsEnvironment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import jmri.util.JmriJFrame;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.AbstractButtonFinder;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.Assert;

/**
 * Swing jfcUnit tests for the turnout table
 *
 * @author	Bob Jacobsen Copyright 2009, 2010
 */
public class TurnoutTableWindowTest extends jmri.util.SwingTestCase {

    public void testShowAndClose() throws Exception {
        if (GraphicsEnvironment.isHeadless()) {
            return; // can't Assume in TestCase
        }

       // ask for the window to open
        TurnoutTableAction a = new TurnoutTableAction();
        a.actionPerformed(new java.awt.event.ActionEvent(a, 1, ""));

        // Find new table window by name
        JmriJFrame ft = JmriJFrame.getFrame(Bundle.getMessage("TitleTurnoutTable"));
        flushAWT();

        // Find the add button
        AbstractButtonFinder abfinder = new AbstractButtonFinder("Add...");
        JButton button = (JButton) abfinder.find(ft, 0);
        Assert.assertNotNull(button);

        // Click button to open add window
        getHelper().enterClickAndLeave(new MouseEventData(this, button));

        // Find add window by name
        JmriJFrame fa = JmriJFrame.getFrame("Add New Turnout");
        Assert.assertNotNull("add window", fa);

        // Find hardware number field
        NamedComponentFinder ncfinder = new NamedComponentFinder(JComponent.class, "sysName");
        JTextField sysNameField = (JTextField) ncfinder.find(fa, 0);
        Assert.assertNotNull(sysNameField);

        // set to "1"
        
        // The following line works on the CI servers, but not in some standalone cases
        //getHelper().sendString(new StringEventData(this, sysNameField, "1"));
        sysNameField.setText("1"); // workaround
        
        flushAWT();
        Assert.assertEquals("name content", "1", sysNameField.getText());

        // Find system combobox
        ncfinder = new NamedComponentFinder(JComponent.class, "prefixBox");
        JComboBox<?> prefixBox = (JComboBox<?>) ncfinder.find(fa, 0);
        Assert.assertNotNull(prefixBox);
        // set to "Internal"
        prefixBox.setSelectedItem("Internal");
        Assert.assertEquals("Selected system item", "Internal", prefixBox.getSelectedItem());

        // Find the OK button
        abfinder = new AbstractButtonFinder("OK");
        button = (JButton) abfinder.find(fa, 0);
        Assert.assertNotNull(button);

        // Click button to add turnout
        getHelper().enterClickAndLeave(new MouseEventData(this, button));
        
        // Ask to close add window
        TestHelper.disposeWindow(fa, this);

        // Ask to close table window
        TestHelper.disposeWindow(ft, this);

        flushAWT();
        
        // check that turnout was created
        Assert.assertNotNull(jmri.InstanceManager.turnoutManagerInstance().getTurnout("IT1"));
    }

    // from here down is testing infrastructure
    public TurnoutTableWindowTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {"-noloading", TurnoutTableWindowTest.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite(TurnoutTableWindowTest.class);
        return suite;
    }

    // The minimal setup for log4J
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        apps.tests.Log4JFixture.setUp();
        jmri.util.JUnitUtil.resetInstanceManager();
        jmri.util.JUnitUtil.initDefaultUserMessagePreferences();
        jmri.util.JUnitUtil.initInternalTurnoutManager();
        jmri.util.JUnitUtil.initInternalSensorManager();
    }

    @Override
    protected void tearDown() throws Exception {
        apps.tests.Log4JFixture.tearDown();
        super.tearDown();
    }
}
