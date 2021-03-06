// ConnectionConfig.java
package jmri.jmrix.lenz.ztc640;

/**
 * Handle configuring an XPressNet layout connection via a ZTC Controls ZTC640
 * adapter.
 * <P>
 * This uses the {@link ZTC640Adapter} class to do the actual connection.
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2003
  *
 * @see ZTC640Adapter
 */
public class ConnectionConfig extends jmri.jmrix.lenz.AbstractXNetSerialConnectionConfig {

    /**
     * Ctor for an object being created during load process; Swing init is
     * deferred.
     */
    public ConnectionConfig(jmri.jmrix.SerialPortAdapter p) {
        super(p);
    }

    /**
     * Ctor for a functional Swing object with no prexisting adapter
     */
    public ConnectionConfig() {
        super();
    }

    public String name() {
        return "ZTC Controls ZTC640";
    }

    String manufacturerName = "ZTC";

    public String getManufacturer() {
        return manufacturerName;
    }

    public void setManufacturer(String manu) {
        manufacturerName = manu;
    }

    protected void setInstance() {
        if (adapter == null) {
            adapter = new ZTC640Adapter();
        }
    }
}
