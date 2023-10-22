create table user
(
    id        int          not null
        primary key,
    email     varchar(255) null,
    firstname varchar(255) null,
    lastname  varchar(255) null,
    password  varchar(255) null
);

create table vocabulary
(
    id   bigint not null primary key,
    word varchar(255) null
);