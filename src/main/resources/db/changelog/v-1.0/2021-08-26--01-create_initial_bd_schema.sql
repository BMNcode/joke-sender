create sequence if not exists message_seq start 1 increment 50;

create table message (
                         id                  int8            not null,
                         text                varchar(4080),
                         primary key (id)
);