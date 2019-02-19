package Client;

import SharedInterfaces.IClientProxy;
import SharedInterfaces.IServerProxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class StartClient {
    private static IServerProxy iServerProxy;
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            iServerProxy = (IServerProxy) Naming.lookup("rmi://localhost:1099/iServerProxy");
            IClientProxy iClientProxy = new ClientController(iServerProxy);
            Naming.rebind("iClientProxy", iClientProxy);
            ((ClientController) iClientProxy).addThisAsObserver();
            System.out.println("Client started...");

            while (true) {
                iServerProxy.notifyObservers(keyboard.nextLine(), iClientProxy);
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
