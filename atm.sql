create database atm;
use atm;

create table primaryuserdetails(
name varchar(30),
fname varchar(30),
date varchar(30),
month varchar(30),
year varchar(30),
gender varchar(30),
email varchar(30),
marital varchar(30),
address varchar(30),
city varchar(30),
pin varchar(30),
state varchar(30),
applicationid varchar(30) primary key
);

create table secondaryuserdetails(
religion varchar(30),
category varchar(30),
income varchar(30),
education varchar(30),
occupation varchar(30),
pan varchar(30) unique,
aadhar varchar(30) primary key,
senior varchar(30),
existing varchar(30),
applicationid varchar(30),
foreign key(applicationid) references primaryuserdetails(applicationid)
);

create table coreuserdetails(
accountype varchar(30),
cardno varchar(30) primary key,
pin varchar(30) unique,
facilities varchar(30),
id varchar(30),
foreign key(id) references secondaryuserdetails(applicationid)
); 

create table login(
cardno varchar(30),
pin varchar(30),
foreign key(cardno) references coreuserdetails(cardno),
foreign key(pin) references coreuserdetails(pin) on update cascade on delete cascade
);

create table bank(
pin varchar(30),
deposit double,
withdraw double,
balance double,
foreign key(pin) references coreuserdetails(pin) on update cascade on delete cascade
);