package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PNR")
public class PNR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

        private int rn;
        private int customerID;
        private int flightID;
        private String seatNumber;
        private String specialNeeds;


        public PNR(int rn, int customerID, int flightID, String seatNumber, String specialNeeds) {
            super();
            this.rn = rn;
            this.customerID = customerID;
            this.flightID = flightID;
            this.seatNumber = seatNumber;
            this.specialNeeds = specialNeeds;
        }

        public int getCustomerID() {
            return customerID;
        }

        public void setCustomerID(int customerID) {
            this.customerID = customerID;
        }

        public int getFlightID() {
            return flightID;
        }

        public void setFlightID(int flightID) {
            this.flightID = flightID;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public void setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSpecialNeeds() {
            return specialNeeds;
        }

        public void setSpecialNeeds(String specialNeeds) {
            this.specialNeeds = specialNeeds;
        }

        public int getRn() {
            return rn;
        }

        public void setRn(int rn) {
            this.rn = rn;
        }

    }

