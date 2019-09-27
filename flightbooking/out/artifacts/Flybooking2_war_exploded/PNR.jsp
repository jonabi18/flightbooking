<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>PNR</title>
</head>
<body>
test test

<!-- INITIALIZES VARIABLES -->
<c:set var="flight" value="${the_flight}"/>
<c:set var="customer" value="${the_customer}"/>
<c:set var="pnr" value="${the_pnr}"/>

<h2>Reservation Details</h2>

<h3>Flight information</h3>
<p>${flight.from} - ${flight.to}</p>
<p>${flight.flightDate}</p>
<p>Gate: ${flight.gate}</p>
<p>Company: ${flight.flightCompany}</p>
<p>Class: ${flight.flightClass}</p>
<p>Seats available: ${flight.seatAmount}</p>
<br>

<h3>Customer details</h3>
<p>${customer.name}</p>
<p>${customer.gender}</p>

<h3>Order details</h3>
<p>${pnr.seatNumber}</p>
<p>${pnr.specialNeeds}</p>

<form action="ControllerServlet">
    <input type="hidden" name="command" value="BOOK"/>
    <p> Price: ${flight.price}kr </p>
    <input type="Submit" onclick="${flight.from}" value="Book"/>
</form>

<form action="ControllerServlet">
    <input type="Submit" value="Return"/>
</form>
</body>
</html>