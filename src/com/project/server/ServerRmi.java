package com.project.server;

import com.project.metier.*;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRmi {
    public static void main(String[] args ) throws RemoteException, MalformedURLException,
            AlreadyBoundException
    {
        LocateRegistry.createRegistry(1099);
        IClientMetier client = new ClientMetier(); // skeleton & stub
        IGrossisteMetier grossite = new GrossisteMetier(); // skeleton & stub
        IConx cnx = new Conx(); // skeleton & stub
        Naming.bind("rmi://localhost/client", client);
        Naming.bind("rmi://localhost/grossiste", grossite);
        Naming.bind("rmi://localhost/cnx", cnx);
        System.out.println("Serveur RMI en écoute");
    }
}
