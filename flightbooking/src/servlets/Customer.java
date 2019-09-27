package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Customer")
public class Customer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

        private int customerID;
        private String name;
        private String gender;
        private String email;

        public Customer(int customerID, String name, String gender, String email) {
            super();
            this.name = name;
            this.gender = gender;
            this.customerID = customerID;
            this.email = email;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getCustomerID() {
            return customerID;
        }
        public void setCustomerID(int customerID) {
            this.customerID = customerID;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }



        public void setMail(String email) {

            if (email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("You must provide a valid email address");
            }

        }
    }
