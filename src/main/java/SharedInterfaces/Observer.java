package SharedInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer<T> extends Remote {
    default void notify(T message) throws RemoteException{
        System.out.println(message);
    }
}
