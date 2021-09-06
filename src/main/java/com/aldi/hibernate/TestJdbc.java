package com.aldi.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_one_to_one?useSSL=false&serverTimezone=Asia/Jakarta";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("connecting to db: " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
