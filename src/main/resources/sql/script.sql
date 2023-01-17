create table users
(
    username varchar(50)  not null primary key,
    password varchar(500) not null,
    enabled  boolean      not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username, authority);

insert into users
values ('happy', '12345', true);
insert into authorities
values ('happy', 'admin');

create table customers
(
    id       SERIAL primary key,
    email    varchar(100) not null,
    password varchar(500) not null,
    role     varchar(100)

);

insert into customers
values (default, 'vicky.rahadian@gmail.com', '12345', 'ROLE_admin');