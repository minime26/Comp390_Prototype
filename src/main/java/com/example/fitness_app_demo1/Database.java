package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
11/19       Mo          Created class





package edu.comp390.studyapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String jdbcUrl;
    public Database(String jdbcUrl) { this.jdbcUrl = jdbcUrl; }
    public static Database production() { return new Database("jdbc:sqlite:study_partner.db"); }
    public Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(jdbcUrl);
        c.createStatement().execute("PRAGMA foreign_keys = ON");
        return c;
    }
}

 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String db_url;        //creates/opens file in project directory

    private static final String productionUrl = "jdbc:sqlite:fitness.db";

    private static final String test_url = "jdbc:sqlite::memory:";      //in-memory url for testing

    public Database(String jbdcUrl) { this.db_url = jbdcUrl; }        //accepts a url

    //Used in production to point to the production url
    public static Database production() {
        return new Database(productionUrl);
    }

    //Used for testing
    public static Database testDb() {
        return new Database(test_url);
    }

    //Return a connection to the db
    public Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(db_url);     //open connection using db_url
        c.createStatement().execute("PRAGMA foreign_keys = ON");        //enforce foreign keys
        return c;
    }
}
