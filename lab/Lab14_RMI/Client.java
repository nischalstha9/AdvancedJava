package lab.Lab14_RMI;

import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            AdderInterface skeleton = (AdderInterface) Naming.lookup("rmi://localhost:6800/remoteAdder");
            int[] nums = { 1, 2, 3 };
            System.out.println(skeleton.add(nums));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
