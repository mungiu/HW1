package Server;

import SharedInterfaces.IServerProxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartServer {
    public static void main(String[] args) {
        IServerProxy iServerProxy = new ServerController();

        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("iServerProxy", iServerProxy);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Server started...");
    }
}
