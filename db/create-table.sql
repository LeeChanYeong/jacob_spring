create table member (
	memberId int not null primary key auto_increment,
	email varchar(100) not null,
	password char(64) not null,
	name varchar(20) not null,
	token char(128),
	cdate datetime not null default current_timestamp(),
	udate timestamp not null,
	unique (email),
	unique (token)
);