package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
11/19       Mo          Created class


 */

import java.sql.*;

public class DbInit {

    public static void init(Database db) throws SQLException{
        try (Connection c = db.getConnection()) {
            init(c);
        }
    }
    //accepts a connection - can be used for temp db for testing
    public static void init(Connection c) throws SQLException {

        try (Statement s = c.createStatement()) {
            //User table
            s.execute("""
                CREATE TABLE IF NOT EXISTS users (    
                    user_id         TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,  
                    reg_date        TEXT NOT NULL,               --LocalDate -> "YYYY-MM-DD"
                    gender          TEXT NOT NULL,               --ENUM via .name()
                    pass            TEXT NOT NULL,               --password hash    
                    first_name      Text NOT NULL,
                    last_name       Text NOT NULL,
                    age             INTEGER NOT NULL,
                    height          INTEGER NOT NULL,            --inches
                    start_weight    REAL NOT NULL, 
                    current_weight  REAL NOT NULL       
                )
            """);

            //Goals table
            s.execute("""
                CREATE TABLE IF NOT EXISTS goals (
                    goal_id          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    user_id         TEXT NOT NULL,                  --foreign key
                    is_active       INTEGER NOT NULL 
                         CHECK(is_active IN(0, 1)),                 --1=true | 0=false
                    start_weight        REAL NOT NULL, 
                    current_weight      REAL NOT NULL,    
                    target_weight       REAL NOT NULL,  
                    start_date          TEXT NOT NULL,               --LocalDate -> "YYYY-MM-DD"
                    end_date            TEXT,                        --LocalDate -> "YYYY-MM-DD"
                    FOREIGN KEY(user_id) REFERENCES users(user_id)   
                    )
                """);

            //Logs table
            s.execute("""
                CREATE TABLE IF NOT EXISTS logs (
                    log_id          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    user_id         TEXT NOT NULL,                  --foreign key
                    goal_id         INTEGER NOT NULL,               --foreign key
                    log_date        TEXT NOT NULL,                  --LocalDate -> "YYYY-MM-DD"
                    weight          REAL NOT NULL,
                    steps           INTEGER NOT NULL,
                    consumed        INTEGER NOT NULL,                       --calorie-intake
                    burned          INTEGER NOT NULL,                       --calories burned
                    activity        TEXT,                                   --ENUM via .name() - workout type
                    duration        INTEGER NOT NULL CHECK (duration >= -1),     --workout duration
                    bmi             REAL NOT NULL,              
                    UNIQUE(user_id, log_date),                      -- one log per user per day
                    FOREIGN KEY(goal_id) REFERENCES goals(goal_id),
                    FOREIGN KEY(user_id) REFERENCES users(user_id)   
                )
            """);


        }


    }

}
