create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("ushasree@gmail.com", "Uniform@123"); 
insert into login values("test1@gmail.com", "Uniform@123");

create table category(
CategoryName varchar(50),
Description varchar(50),
MetatagTitle varchar(50),
MetatagDescription varchar(50));

insert into category values("Sports wear","Sports","Sports","Sports");
insert into category values("Cultural wear","Cultural",	"Cultural",	"Cultural");
insert into category values("Weekend uniform","Weekend","Weekend","Weekend");
insert into category values("Formal wear","formal","formal","formal");
insert into category values("Sports","SportsShoes","Shoes","SportsShoes");
