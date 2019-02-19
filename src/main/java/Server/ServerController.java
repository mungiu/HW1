package Server;

import SharedInterfaces.IServerProxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerController implements IServerProxy {
    public ServerController() {

        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
