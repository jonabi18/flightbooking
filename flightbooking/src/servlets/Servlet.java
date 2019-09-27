package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


//
// This servlet contains functions that call all our major functions.
// In order to preserve low coupling we will sometimes call functions from other servlets.
// In summary, this servlet calls functions, but it does not define them.

    @WebServlet("/Servlet")
    public class Servlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        private dbUtilities dataUtils;

        //defines where the database is located
        @Resource(name="jdbc/Flybokking2")
        private DataSource dataSource;

        /** Overrides the init function
         *  The init function can be used to initialize fields when the object is created.
         *  In this case we initialize our dbUtilities while passing our datasource as a parameter.
         *  This is a nessecary step in order to use this datasource in our functions.
         */
        @Override
        public void init() throws ServletException {
            super.init();

            try {
                dataUtils = new dbUtilities(dataSource);
                System.out.println(dataSource);
            }
            catch (Exception exc) {
                throw new ServletException(exc);
            }
        }
        public Servlet() {

        }

        /**
         * This doGet method will process the command recieved from the request object, and call the appropriate method.
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                // Reads the "command" parameter
                String theCommand = request.getParameter("command");

                // If the command is missing, then default to listing random flights (5 latest added flights)
                if (theCommand == null) {
                    theCommand = "LIST";
                }

                switch (theCommand) {

                    case "LIST":
                        getRecentFlights(request, response);
                        break;

                    case "FILTER":
                        filter(request, response);
                        break;

                    case "BOOK":
                        String flightNumber = request.getParameter("flightNumber");
                        bookAFlight(request, response, flightNumber);
                        break;

                    case "REGISTER":
                        String name = request.getParameter("name");
                        String gender = request.getParameter("gender");
                        String email = request.getParameter("email");
                        createCustomer(request,response,name, gender, email);
                        break;

                    case "VIEW":
                        String flightNum = request.getParameter("flightNumber");
                        viewBooking(request, response, flightNum);
                        break;

                    case "SEARCH":
                        String RN = request.getParameter("RN");
                        if (RN!=null && RN!="") {
                            searchRN(request, response, RN);
                        }
                        else {
                            getRecentFlights(request,response);
                        }
                        break;

                    default:
                        //functionName(request, response);
                }

            }
            catch (Exception exc) {
                throw new ServletException(exc);

            }

        }


        private void searchRN(HttpServletRequest request, HttpServletResponse response, String RN) throws Exception {

            //first we find the PNR with the RN
            PNR thePNR = dataUtils.getPNR(RN);

            //second we run getFlight on the ID that is inside the PNR
            Flight theFlight = dataUtils.getFlight(thePNR.getFlightID()+"");

            //third we run the getCustomer on the ID that is inside the PNR
            Customer theCustomer = dataUtils.getCustomer(thePNR.getCustomerID());

            request.setAttribute("the_pnr", thePNR);
            request.setAttribute("the_flight", theFlight);
            request.setAttribute("the_customer", theCustomer);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/PNR.jsp");
            dispatcher.forward(request, response);
        }

        private void getRecentFlights(HttpServletRequest request, HttpServletResponse response) throws Exception {
            List<Flight> recentFlights = dataUtils.getRecentFlights();

            request.setAttribute("FLIGHTS", recentFlights);

            //response.sendRedirect(request.getContextPath() + "/index.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

        private void bookAFlight(HttpServletRequest request, HttpServletResponse response, String flightNumber) throws Exception {
            boolean bookSuccess = dataUtils.bookFlight(flightNumber);

            //request.setAttribute("#", pnr);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

        //finds spesific flight, assigns it to attributes, forwards to bookingpage
        private void viewBooking(HttpServletRequest request, HttpServletResponse response, String flightNumber) throws Exception {
            //retrieves the flight where flight_id = flightNumber
            Flight theFlight = dataUtils.getFlight(flightNumber);

            request.setAttribute("the_flight", theFlight);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/bookingPage.jsp");
            dispatcher.forward(request, response);
        }
        private void createCustomer(HttpServletRequest request, HttpServletResponse response, String name, String gender, String email) throws Exception {
            dataUtils.createCustomer(name, gender, email);

            System.out.println("Customer created.");

            // After creating a customer, the recent flights should be shown at homepage
            getRecentFlights(request,response);


            //remove below if wrong
            //response.sendRedirect(request.getContextPath() + "/index.jsp");
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            //dispatcher.forward(request, response);
        }
        private void filter(HttpServletRequest request, HttpServletResponse response) throws Exception {

            String priceFilter = request.getParameter("priceFilter");
            List<Flight> flights = new ArrayList<>();
            switch(priceFilter) {

                case "highToLow" :
                    flights = dataUtils.filtering("highToLow");
                    break;

                case "lowToHigh" :
                    flights = dataUtils.filtering("lowToHigh");
                    break;


                default:
                    getRecentFlights(request,response);
            }
            request.setAttribute("FLIGHTS", flights);

            //response.sendRedirect(request.getContextPath() + "/index.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
}
