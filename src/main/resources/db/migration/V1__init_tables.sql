create table departments
(
    id   bigint auto_increment,
    name varchar(256) not null,
    constraint departments_pk
        primary key (id)
);

create table students
(
    id            bigint auto_increment,
    name          varchar(256) not null,
    surname       varchar(256) not null,
    department_id bigint       null,
    constraint students_pk
        primary key (id),
    constraint students_departments_id_fk
        foreign key (department_id) references departments (id)
);