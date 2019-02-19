package Client;

import SharedInterfaces.IClientProxy;
import SharedInterfaces.IServerProxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientController implements IClientProxy {
    private IServerProxy iServerProxy;

    public ClientController(IServerProxy iServerProxy){
        this.iServerProxy = iServerProxy;

        try {
            UnicastRemoteObject.exportObject(this,0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addThisAsObserver(){
        try {
            iServerProxy.addObserver(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
