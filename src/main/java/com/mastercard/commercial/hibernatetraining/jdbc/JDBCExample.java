package com.mastercard.commercial.hibernatetraining.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by e068636 on 10/29/2019.
 *
 *
 create table employee(
 id number,
 name varchar2(50),
 address varchar2(50)
 );

 insert into employee(id, name, address) values(1, 'Inter1', 'Address1');
 insert into employee(id, name, address) values(2, 'Inter2', 'Address2');

 *
 */
public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        printEmployeeData();
    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "SDNG_PC_DBA", "smartdata");
    }


    private static void printEmployeeData() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee";

        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String address = rs.getString("Address");

                System.out.println("Name: " + name + ", Address: " + address);
            }
        } catch (Exception ex) {
            System.err.println("Error running the SQL");

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            getConnection().close();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

}
