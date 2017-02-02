package wolfe.michael.InnerClasses;

/**
 * Created by michaelwolfe on 2/2/17.
 */
public class ConnectionManager {

    private class ManagedConnection{
        private String ipAddress;
        private int port;
        private Protocol protocol;
        private ConnectionStatus status;

        public ConnectionStatus getConnectionStatus(){
            return null;
        }
    }
}
