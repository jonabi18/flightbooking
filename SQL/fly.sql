begin 
;
create database FlightBooking1;
use FlightBooking1;

create table Customer(
customer_id int not null auto_increment,
first_name varchar(15) not null,
middle_name varchar(15),
last_name varchar(15)not null, 
customer_address varchar(50),
email varchar(50),
phone varchar(15),
constraint Customer_pk primary key (customer_id));

create table FlightDetail(
flight_ID int not null,
seatRow int not null,
seatNumber int not null,
price int not null,
planeType varchar(20),
departure datetime,
arrival datetime,
toAirport varchar(20),
fromAirport varchar(20),
constraint Flight_pk primary key (flight_ID));

/*create table Seat(
seatRow int not null,
seatNumber int not null,
constraint seat_pk primary key (seatRow, seatNumber));*/

create table Ticket(
ticket_ID int not null auto_increment,
customer_ID int not null,
flight_ID int not null,
constraint ticket_pk primary key (ticket_ID),
foreign key (customer_ID) references customer(customer_id),
foreign key (flight_id) references flightdetail(flight_id));

/*foreign key (customer_id) references Customer(customer_id),
foreign key (ticket_id) references ticket(ticket_id));*/

/*constraint ticket_fk foreign key (customer_ID)references customer(customer_ID),
constraint ticket_fk foreign key (flight_ID) references flightdetail(flight_ID));*/

select *
from customer 
inner join ticket on customer.customer_id = ticket.customer_id
inner join flightdetail on flightdetail.flight_ID = ticket.flight_id;

Insert into customer(first_name, middle_name, last_name, customer_address, email, phone)
values('Leif', 'gustav', 'Larsen', 'bispeveien 900', 'hi@gmail.com','32020202');

insert into flightdetail(flight_ID, seatRow, seatNumber, price, planeType, departure, arrival, toAirport, fromAirport)
values(2, 2, 2, 1000, 'boeng', '2019-10-10', '2019-10-11', 'gardemoen', 'torp');

insert into ticket(customer_id, flight_id)
values(1,2);

select *
from customer;

select *
from ticket;

select *
from flightdetail;

drop table flightdetail;

drop table ticket;

drop table customer;
