package com.moseswong.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCExecutor {
    public static void main(String... args){
        System.out.println("Hello Learning JDBC");
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                                                                "hplussport",
                                                                    "postgres",
                                                                    "root");

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customerDAO.findAllSorted(20).forEach(System.out::println);
            System.out.println("Paged");
            for(int i=1; i<3; i++){
                System.out.println("Page Number: "+ i);
                customerDAO.findAllPaged(10, i).forEach(System.out::println);
            }
           // OrderDAO orderDAO = new OrderDAO(connection);
           // List<Order> orders = orderDAO.getOrdersForCustomer(789);
           // orders.forEach(System.out::println);


            //Order order = orderDAO.findById(1000);
           // System.out.println(order);

            /*
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("John");
            customer.setLastName("Adams");
            customer.setEmail("jadams.wh.gov");
            customer.setAddress("1234 Main St");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setPhone("(555) 555-9845");
            customer.setZipCode("01234");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("john.adams@wh.gov");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());
            */


            /*
            Customer customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstName() + " "+
                    customer.getLastName()+" "+customer.getEmail());
            customer.setEmail("gwashington@wh.gov");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName() + " "+
                    customer.getLastName()+" "+customer.getEmail());
            */

            //Customer customer = customerDAO.findById(1000);
            //System.out.println(customer.getFirstName() + " "+ customer.getLastName());

            /*
            Customer customer = new Customer();
            customer.setFirstName("Ha Ha");
            customer.setLastName("tan");
            customer.setEmail("hello@gmail.com");
            customer.setPhone("667 1234");
            customer.setAddress("1 North Bridge Road");
            customer.setCity("Singapore");
            customer.setState("ChinaTown");
            customer.setZipCode("123456");
            customerDAO.create(customer);
            */

            /*
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            */
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
