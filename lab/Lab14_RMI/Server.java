package lab.Lab14_RMI;

import java.rmi.*;

public class Server {
    public static void main(String args[]) {
        try {
            AdderInterface stub = new RemoteAdder();
            Naming.rebind("rmi://localhost:6800/remoteAdder", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
