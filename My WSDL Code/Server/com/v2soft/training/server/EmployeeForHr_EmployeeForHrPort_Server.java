
package com.v2soft.training.server;

import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.3.4
 * 2019-10-29T11:06:06.428-04:00
 * Generated source version: 3.3.4
 *
 */

public class EmployeeForHr_EmployeeForHrPort_Server extends HttpServlet {

    public EmployeeForHr_EmployeeForHrPort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new EmployeeForHrPortImpl();
        String address = "http://localhost:8081/EmployeeForHr";
        Endpoint.publish(address, implementor);
    }

    /*public static void main(String args[]) throws java.lang.Exception {
        new EmployeeForHr_EmployeeForHrPort_Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }*/
    
    public void init() throws javax.servlet.ServletException {
          System.out.println("----------");
          System.out.println("---------- Initialized successfully ----------");
          System.out.println("----------");
    }
}
