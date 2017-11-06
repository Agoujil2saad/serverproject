package com.project.metier;

import com.project.dao.DBUserQueries;
import com.project.model.DBManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

public class Conx extends UnicastRemoteObject implements IConx {

    public Conx() throws RemoteException {
    }

    @Override
    public boolean checkcnx(String uid, String password, String type) throws  RemoteException{
        System.out.println("---------------------------");
        DBManager dbm = new DBManager(); // by default it connects to MYSQL
        try {
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    System.out.println("Could not connect to the database...");
                }
            }
            String auth_query = DBUserQueries.Auth(uid, password, type);
           ResultSet res = dbm.ExecuteResultSet(auth_query);
            if (res.first()) {
                System.out.println("true");
                return true;
            } else {
                System.out.println("false");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error connecting to DB for Authentication Client");
            return false;
        }
    }
}





