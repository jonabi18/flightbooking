package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class Flight {
        private int flightNumber;
        private int price;
        private String flightCompany;
        private String flightDate;
        private String to;
        private String from;
        private int revenue;
        private String flightClass;
        private String duration;
        private int seatAmount;
        private String visibleSeatAmount;
        private String airplaneType;
        private String gate;


        public Flight(int flightNumber, int price, String flightCompany, String flightDate, String to, String from,
                      int revenue, String flightClass, String duration, int seatAmount, String visibleSeatAmount, String airplaneType, String gate) {
            super();
            this.flightNumber = flightNumber;
            this.price = price;
            this.flightCompany = flightCompany;
            this.flightDate = flightDate;
            this.to = to;
            this.from = from;
            this.revenue = revenue;
            this.flightClass = flightClass;
            this.duration = duration;
            this.seatAmount = seatAmount;
            this.visibleSeatAmount = visibleSeatAmount;
            this.airplaneType = airplaneType;
            this.gate = gate;
        }
        // Getters and Setters
        public int getFlightNumber() {
            return flightNumber;
        }
        public void setFlightNumber(int flightNumber) {
            this.flightNumber = flightNumber;
        }
        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public String getFlightCompany() {
            return flightCompany;
        }
        public void setFlightCompany(String flightCompany) {
            this.flightCompany = flightCompany;
        }
        public String getFlightDate() {
            return flightDate;
        }
        public void setFlightDate(String flightDate) {
            this.flightDate = flightDate;
        }
        public String getTo() {
            return to;
        }
        public void setTo(String to) {
            this.to = to;
        }
        public String getFrom() {
            return from;
        }
        public void setFrom(String from) {
            this.from = from;
        }
        public int getRevenue() {
            return revenue;
        }
        public void setRevenue(int revenue) {
            this.revenue = revenue;
        }
        public String getFlightClass() {
            return flightClass;
        }
        public void setFlightClass(String flightClass) {
            this.flightClass = flightClass;
        }
        public String getDuration() {
            return duration;
        }
        public void setDuration(String duration) {
            this.duration = duration;
        }
        public int getSeatAmount() {
            return seatAmount;
        }
        public void setSeatAmount(int seatAmount) {
            this.seatAmount = seatAmount;
        }
        public String getVisibleSeatAmount() {
            return visibleSeatAmount;
        }
        public void setVisibleSeatAmount(String visibleSeatAmount) {
            this.visibleSeatAmount = visibleSeatAmount;
        }
        public String getAirplaneType() {
            return airplaneType;
        }
        public void setAirplaneType(String airplaneType) {
            this.airplaneType = airplaneType;
        }
        public String getGate() {
            return gate;
        }
        public void setGate(String gate) {
            this.gate = gate;
        }


    }

