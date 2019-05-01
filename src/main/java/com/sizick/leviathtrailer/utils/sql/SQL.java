package com.sizick.leviathtrailer.utils.sql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sizick.leviathtrailer.LeviathTrailerBot;

public class SQL {
    private String url= "";
    ResultSet resultSet = null;
    Statement statement = null;
    String driver = "";
    String user = "";
    String database = "";
    String password = "";
    String port = "";
    String host = "";
    Connection c = null;

    public SQL(String Host, String db, String username, String password) {
        this.host = Host;
        this.database = db;
        this.user = username;
        this.password = password;
        url = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password=" + password;
        driver = ("org.mariadb.jdbc.Driver");
    }

    public SQL(String filePath) {
        url = "jdbc:sqlite:" + new File(filePath).getAbsolutePath();
        driver = ("org.sqlite.JDBC");
    }

    public boolean isClosed() {
        boolean b = false;
        try {
            if (this.c == null || this.c.isClosed() || this.c.isValid(5)) {
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public void open() {
        if(isClosed()) {
            try {
                Class.forName(driver);
                this.c = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println("Could not connect to MySQL/SQLite server! because: " + e.getMessage());
                System.exit(0);
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found!");
                System.exit(0);
            }
        }
    }

    public Connection getConn() {
        return this.c;
    }

    public void closeConnection() {
        if(!isClosed()) {
            try {
                this.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.c = null;
        }
    }

    public static ResultSet get(String syntax) {
        ResultSet res = null;
        try {
            res = LeviathTrailerBot.getSQL().getConn().createStatement(1003, 1007).executeQuery(syntax);
        }
        catch (SQLException e) {
            System.out.println("Error with a SQL syntax : " + syntax);
            e.printStackTrace();
        }
        return res;
    }

    public static void set(String syntax) {
        try{
            LeviathTrailerBot.getSQL().getConn().createStatement().executeUpdate(syntax);
        }
        catch (SQLException e) {
            System.out.println("Error with a SQL syntax : " + syntax);
            e.printStackTrace();
        }
    }

    public static void setNoErrorLog(String syntax) {
        try{
            LeviathTrailerBot.getSQL().getConn().createStatement().executeUpdate(syntax);
        }
        catch (SQLException e) {}
    }

    public static boolean isTable(final String table) {
        Statement statement;
        try {
            statement = LeviathTrailerBot.getSQL().getConn().createStatement();
        }
        catch (SQLException e) {
            return false;
        }
        try {
            statement.executeQuery("SELECT * FROM " + table);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }
}