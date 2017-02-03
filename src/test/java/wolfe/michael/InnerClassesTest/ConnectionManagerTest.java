package wolfe.michael.InnerClassesTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wolfe.michael.InnerClasses.Connection;
import wolfe.michael.InnerClasses.ConnectionManager;
import wolfe.michael.InnerClasses.ConnectionStatus;
import wolfe.michael.InnerClasses.Protocol;

/**
 * Created by michaelwolfe on 2/2/17.
 */
public class ConnectionManagerTest {

    ConnectionManager manager1;
    ConnectionManager manager2;
    ConnectionManager manager3;
    Connection kinect1;
    Connection kinect2;
    Connection kinect3;



    @Before
    public void setUp(){
        manager1 = new ConnectionManager();
        kinect1 = manager1.getConnection("120.0.0.0", 8000, Protocol.HTTP);
        manager2 = new ConnectionManager();
        kinect2 = manager2.getConnection("120.1.0.0", Protocol.SSH);
        manager3 = new ConnectionManager();
        kinect3 = manager3.getConnection("120.0.1.0", 8080);
    }

    @Test
    public void getIpAddressTestOne(){
        String expected = "120.0.0.0";
        String actual = kinect1.getIpAddress();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getIpAddressTestTwo(){
        String expected = "120.1.0.0";
        String actual = kinect2.getIpAddress();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getIpAddressTestThree(){
        String expected = "120.0.1.0";
        String actual = kinect3.getIpAddress();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPortTestOne(){
        int expected = 8000;
        int actual = kinect1.getPort();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getProtocolTest(){
        Protocol expected = Protocol.HTTP;
        Protocol actual = kinect1.getProtocol();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStatusTest(){
        ConnectionStatus expected = ConnectionStatus.OPEN;
        ConnectionStatus actual = kinect1.getStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void connectTest(){
        String expected ="Connected to 128.0.0.0:8000 via HTTP.";
        String actual = kinect1.connect();
        Assert.assertEquals(expected, actual);
    }


}
