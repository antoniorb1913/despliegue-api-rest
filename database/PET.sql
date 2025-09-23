create database PET;

use PET;

create table PETS (
    id int primary key auto_increment,
    name varchar(255),
    born date,
    category varchar(255),
    chip varchar(255)
);