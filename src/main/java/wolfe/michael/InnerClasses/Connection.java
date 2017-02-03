package wolfe.michael.InnerClasses;

/**
 * Created by michaelwolfe on 2/2/17.
 */
public interface Connection {

    String getIpAddress();
    int getPort();
    Protocol getProtocol();
    String connect();
    ConnectionStatus getStatus();

}
