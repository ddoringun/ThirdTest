create database bank;

show databases;

create table bank(
	id varchar(20) not null,
	name varchar(20) not null,
	age varchar(10),
	tel varchar(20)
);

desc bank; 

insert into bank values(test1,hong,23,);

select * from bank;

update bank set tel = ? where = id = ?;

select * from bank;

delete from bank where id = ?;

select * from bank;
