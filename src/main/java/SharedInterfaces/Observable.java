package SharedInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface Observable<T> extends Remote {
    List<Observer> observers = new ArrayList<>();

    default void addObserver(Observer obs) throws RemoteException {
        if (!observers.contains(obs))
            observers.add(obs);
    }

    default void removeObserver(Observer obs) throws RemoteException {
        if (observers.contains(obs))
            observers.remove(obs);
    }

    default void notifyObservers(T message, Observer<String> observer) throws RemoteException {
        for (Observer obs : observers) {
            if (!obs.equals(observer))
                obs.notify(message);
            System.out.println(message);
        }
    }
}
