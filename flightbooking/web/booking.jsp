<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Booking</title>
    <link href="css/bookingpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrapper">
    <div id="content">

        <!-- Here the flight information will be displayed, with the option to book a flight -->
        <div id="flightInformation">
            <c:set var="flight" value="${the_flight}"/>

            <h2>Flydetaljer</h2>
            <p>${flight.from} - ${flight.to}</p>
            <p>${flight.flightDate}</p>
            <p>Gate: ${flight.gate}</p>
            <p>Company: ${flight.flightCompany}</p>
            <br>

            <form action="ControllerServlet">
                <input type="hidden" name="command" value="BOOK"/>
                <input type="hidden" name="flightNumber" value="${flight.flightNumber}"/>
                <p> Price: ${flight.price}kr </p> <br>
                Ticket amount:
                <input type="number" name="ticketAmount"> <br>
                <input type="Submit" value="Book"/>
            </form>

        </div>
    </div>
</div>


<form action="ControllerServlet">
    <input type="Submit" value="Return"/>
</form>

</body>
</html>