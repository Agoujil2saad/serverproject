package com.project.metier;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConx extends Remote {
    public boolean  checkcnx(String uid, String password , String type) throws RemoteException;
}
