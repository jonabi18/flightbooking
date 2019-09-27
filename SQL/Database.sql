begin 
;
create database FlightBooking;
use FlightBooking;
create table Customer(
customerID int not null auto_increment,
firstName varchar(20) not null,
middleName varchar (20),
lastName varchar (20) not null, 
customerAddress varchar (50),
email varchar (70),
phoneNumber varchar (20),
disabilities int,
constraint Customerpk primary key (customerID));

insert into Customer (customerID, firstName, middleName, lastName, customerAddress, email, phoneNumber, disabilities)
values (1, "Remi", "Rumineco", "Rudi", "Rudiveien 95", "rudigutten@hotmail.no", "48440453", 69);

create table Seat(
seatRow int not null,
seatNumber int not null,
constraint seatID primary key (seatRow, seatNumber));

insert into seat (seatRow, seatNumber)
values (1,1);

create table FlightDetails(
flightID int not null auto_increment,
price int,
planeType varchar (50),
fromAirport varchar (20),
toAirport varchar (20),
constraint flightDetailspk primary key (flightID));

insert into FlightDetails (flightID, price, planeType, fromAirport, toAirport)
values (1, 6969, "Boeing", "Gardermoen", "Kjevik");

create table Ticket(
ticketID int not null auto_increment,
customerID int,
flightID int,
seatRow int,
seatNumber int,
constraint ticketpk primary key (ticketID),
foreign key (customerID) references Customer(customerID),
foreign key (flightID) references FlightDetails(flightID),
constraint seatfk foreign key (seatRow, seatNumber) references seat(seatRow, seatNumber));


select *
from Customer;

select*
from seat;

select *
from customer, seat;

select *
from ticket;

drop table customer;
drop table seat;
drop table flightDetails;
drop table Ticket;
