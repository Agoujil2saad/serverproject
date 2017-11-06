package com.project.dao;

public class DBUserQueries {
    public static String getUsers(){
        return "select * from users";
    }
    public static String insertUser(String username, String password, String type) {
        return "INSERT INTO users(username, password, type) VALUES ('" + username  + "'" +
                ", '" + password + "', '" + type.toLowerCase() + "')";
    }
    public static String selectUserById(int id){
        return "SELECT * FROM users where id=" + id ;
    }


    public static String selectUserByUsername(String name){
        return "SELECT * FROM users where username='" + name + "'" ;
    }


    public static String Auth(String name, String password, String type){
        return "SELECT * FROM users where username='" + name + "'"+"and password = '"+password+"' and type ='"+type.toLowerCase()+"'" ;
    }
}

