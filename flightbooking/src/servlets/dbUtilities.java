package servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import servlets.Flight;
import servlets.PNR;
import servlets.Customer;




    /**
     * This servlet establishes a connection to our database.
     * It also contains the functions that send SELECT, UPDATE, DROP queries etc
     */
    @WebServlet("/dbUtilities")
    public class dbUtilities extends HttpServlet {
        private static final long serialVersionUID = 1L;

        private DataSource dataSource;

        public dbUtilities(DataSource dataSource) {
            this.dataSource = dataSource;
        }


        public List<FlightDetail> getRecentFlights() throws Exception {

            List<FlightDetail> flights = new ArrayList<>();

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                System.out.println("Recent flights called.");
                // Step 1: get a connection
                myConn = dataSource.getConnection();

                // Step 2: create sql statement
                String sql = "SELECT * FROM flightDetail LIMIT 5";

                myStmt = myConn.createStatement();

                // Step 3: execute query
                myRs = myStmt.executeQuery(sql);

                // Step 4: process result set
                while (myRs.next()) {

                    // Defining the variables
                    int flight_ID = myRs.getInt("flight_ID");
                    int price = myRs.getInt("price");
                    String departure = myRs.getString("departure");
                    String arrival = myRs.getString("arrival");
                    String from = myRs.getString("from");
                    String to = myRs.getString("to");
                   // Boolean business = myRs.getBoolean("business_class");
                    int seatRow = myRs.getInt("seatRow");
                    int seatNumber = myRs.getInt("seatNumber")
                   // String gate = myRs.getString("gate");

                    //very fancy code below
                   // String flightClass = business?"Business":"Economy";



                    // create new flight object
                    FlightDetail tempFlight = new FlightDetail(flight_ID, price,
                            departure, arrival, from, to, seatNumber);

                    // add it to the list of flights
                    flightDetail.add(tempFlight);
                }

                return flightDetail;
            }
            finally {
                // close JDBC objects
                close(myConn, myStmt, myRs);
            }


        }
        private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

            try {
                if (myRs != null) {
                    myRs.close();
                }

                if (myStmt != null) {
                    myStmt.close();
                }

                if (myConn != null) {
                    myConn.close();   // doesn't really close it ... just puts back in connection pool
                }
            }
            catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        /**private String VisibleSeatRow(int seatRow) {
            if(seatRow>9) {
                return ("9+");
            } else {
                return (seatRow+"");
            }
         */


        public FlightDetail getFlightDetail(String flight_ID) throws Exception {
            FlightDetail theFlight = null;

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                System.out.println("getFlight is called.");
                // Step 1: get a connection
                myConn = dataSource.getConnection();

                // Step 2: create sql statement
                String sql = "SELECT * FROM flightDetail WHERE flight_ID=" + flight_ID;

                myStmt = myConn.createStatement();

                // Step 3: execute query
                myRs = myStmt.executeQuery(sql);

                // Step 4: process result set
                while (myRs.next()) {

                    // Defining the variables
                    int flight_ID = myRs.getInt("flight_ID");
                    int price = myRs.getInt("price");
                    String departure = myRs.getString("departure");
                    String arrival = myRs.getString("arrival");
                    String from = myRs.getString("from");
                    String to = myRs.getString("to");
                    //Boolean business = myRs.getBoolean("business_class");
                    int seatRow = myRs.getInt("seatRow");
                    int seatNumber = myRs.getInt("seatNumber");
                    //String gate = myRs.getString("gate");

                    //very fancy code below
                   // String flightClass = business?"Business":"Economy";



                    // create new flight object
                    theFlight = new FlightDetail(flight_ID, price,
                            departure, arrival, from, to, seatNumber);

                    System.out.println("Flight:" + flight_ID + from + to);
                }

                return theFlight;
            }
            finally {
                // close JDBC objects
                close(myConn, myStmt, myRs);
            }
        }

        public boolean bookFlight(String flightNumber) {
            // Get flightID
            // Get costumerID
            // kapow! apple pen!
            return false;
        }



        public PNR getPNR(String RN) throws Exception{
            PNR thePNR = null;

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                System.out.println("getFlight is called.");
                // Step 1: get a connection
                myConn = dataSource.getConnection();

                // Step 2: create sql statement
                String sql = "SELECT * FROM pnr WHERE rn=" + RN;

                myStmt = myConn.createStatement();

                // Step 3: execute query
                myRs = myStmt.executeQuery(sql);

                // Step 4: process result set
                while (myRs.next()) {

                    // Defining the variables
                    int rn = myRs.getInt("rn");
                    int customerID = myRs.getInt("customerID");
                    int flightID = myRs.getInt("flightID");
                    String seatNumber = myRs.getString("seatNumber");
                    String specialNeeds = myRs.getString("specialNeeds");

                    // create new PNR object
                    thePNR = new PNR(rn, customerID,
                            flightID, seatNumber, specialNeeds);

                    System.out.println("PNR:" + rn + customerID + flightID + seatNumber + specialNeeds);
                }

                return thePNR;
            }
            finally {
                // close JDBC objects
                close(myConn, myStmt, myRs);
            }
        }
        public Customer getCustomer(int CID) throws Exception{
            Customer theCustomer = null;

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                System.out.println("getFlight is called.");
                // Step 1: get a connection
                myConn = dataSource.getConnection();

                // Step 2: create sql statement
                String sql = "SELECT * FROM customer WHERE customerID=" + CID;

                myStmt = myConn.createStatement();

                // Step 3: execute query
                myRs = myStmt.executeQuery(sql);

                // Step 4: process result set
                while (myRs.next()) {

                    // Defining the variables
                    int customerID = myRs.getInt("customerID");
                    String name = myRs.getString("name");
                    String gender = myRs.getString("gender");
                    String email = myRs.getString("email");

                    System.out.println("kundeinfo:" + customerID + name + gender + email);
                    // create new PNR object
                    theCustomer = new Customer(customerID,
                            name, gender, email);
                }

                return theCustomer;
            }
            finally {
                // close JDBC objects
                close(myConn, myStmt, myRs);
            }
        }
        public void createCustomer(String name, String gender, String email) throws SQLException {

            Connection myConn = null;
            PreparedStatement st = null;


            try {
                // Step 1: get a connection
                myConn = dataSource.getConnection();

                st = myConn.prepareStatement("insert into customer(name, gender, email) values(?, ?, ?)");


                st.setString(1, name);

                st.setString(2, gender);

                st.setString(3, email);

                st.executeUpdate();
                System.out.println("Customer added.");
            } finally {
                // close JDBC objects
                myConn.close();
                st.close();

            }


            // Close all the connections
            st.close();
            myConn.close();


        }

        public List<Flight> filtering(String filterString) throws Exception {

            List<Flight> flights = new ArrayList<>();

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            String querryString = null;

            if(filterString == "highToLow") {
                querryString = "SELECT * FROM flight order by price DESC";
            } else if(filterString == "lowToHigh") {
                querryString = "SELECT * FROM flight order by price ASC";
            }
            try {
                System.out.println("Filtering flights as requested.");
                // Step 1: get a connection
                myConn = dataSource.getConnection();

                // Step 2: create sql statement
                String sql = querryString;

                myStmt = myConn.createStatement();

                // Step 3: execute query
                myRs = myStmt.executeQuery(sql);

                // Step 4: process result set
                while (myRs.next()) {

                    // Defining the variables
                    int flightID = myRs.getInt("flightID");
                    int price = myRs.getInt("price");
                    String airline = myRs.getString("airline_name");
                    String date = myRs.getString("flight_date");
                    String from = myRs.getString("from_location");
                    String to = myRs.getString("to_location");
                    int revenue = myRs.getInt("revenue");
                    Boolean business = myRs.getBoolean("business_class");
                    String duration = myRs.getString("duration");
                    int seatAmount = myRs.getInt("seat_amount");
                    String visibleSeatAmount = VisibleSeatAmount(seatAmount);
                    String airplaneType = myRs.getString("airplane_type");
                    String gate = myRs.getString("gate");

                    //very fancy code below
                    String flightClass = business?"Business":"Economy";



                    // create new flight object
                    Flight tempFlight = new Flight(flightID, price,
                            airline, date, from, to, revenue,
                            flightClass, duration, seatAmount, visibleSeatAmount, airplaneType, gate);

                    // add it to the list of flights
                    flights.add(tempFlight);
                }

                return flights;
            }
            finally {
                // close JDBC objects
                close(myConn, myStmt, myRs);
            }


        }

    }

