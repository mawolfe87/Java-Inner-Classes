package wolfe.michael.InnerClasses;

import java.util.ArrayList;

/**
 * Created by michaelwolfe on 2/2/17.
 */
public class ConnectionManager {

    private int CONNECTIONS_LIMIT = 100;
    int limit;
    public int numberOfInitializedConnections = 0;
    Connection c;
    private ArrayList connections = new ArrayList<Connection>();

    public ConnectionManager(){
        limit = CONNECTIONS_LIMIT;
    }

    public Connection getConnection(String ipAddress, Protocol protocol){
        if(checkConnectionAvailability()){
            c = new ManagedConnection(ipAddress, protocol);
            addNewConnection(c);
            return c;
        } else
            return new ManagedConnection();
    }

    public Connection getConnection(String ipAddress, int port){
        if(checkConnectionAvailability()){
            c = new ManagedConnection(ipAddress, port);
            addNewConnection(c);
            return c;
        } else
            return new ManagedConnection();
    }

    public Connection getConnection(String ipAddress, int port, Protocol protocol){
        if(checkConnectionAvailability()){
            c = new ManagedConnection(ipAddress, port, protocol);
            addNewConnection(c);
            return c;
        } else
            return new ManagedConnection();
    }

    public boolean checkConnectionAvailability(){
        if(numberOfInitializedConnections == limit)
            return false;
        else {
            numberOfInitializedConnections++;
            return true;
        }
    }

    public void addNewConnection(Connection c){
        connections.add(c);
    }

    private class ManagedConnection implements Connection{
        private String ipAddress;
        private int port;
        private Protocol protocol;
        private ConnectionStatus status;

        public ManagedConnection(){

        }

        public ManagedConnection(String ipAddress, Protocol protocol){
            this.setIpAddress(ipAddress);
            this.setProtocol(protocol);
            this.setStatus(ConnectionStatus.OPEN);
        }

        public ManagedConnection(String ipAddress, int port){
            this.setIpAddress(ipAddress);
            this.setPort(port);
            this.setProtocol(Protocol.HTTP);
            this.setStatus(ConnectionStatus.OPEN);
        }

        public ManagedConnection(String ipAddress, int port, Protocol protocol){
            this.setIpAddress(ipAddress);
            this.setPort(port);
            this.setProtocol(protocol);
            this.setStatus(ConnectionStatus.OPEN);
        }

        public String getIpAddress(){
            return this.ipAddress;
        }

        public void setIpAddress(String address){
            this.ipAddress = address;
        }

        public int getPort(){
            return this.port;
        }

        public void setPort(int port){
            this.port = port;
        }

        public Protocol getProtocol(){
            return this.protocol;
        }

        public void setProtocol(Protocol protocol){
            this.protocol = protocol;
        }

        public ConnectionStatus getStatus() {
            return this.status;
        }

        public void setStatus(ConnectionStatus status){
            this.status = status;
        }

        public String connect(){
            return "Connected to " + getIpAddress() + ":" + getPort() + " via " + getProtocol() + ".";
        }
    }
}
