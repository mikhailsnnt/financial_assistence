create table user_accounts (
                                     id bigserial not null,
                                     account_id bigint not null,
                                     name varchar(250),
                                     currency varchar(5),
                                     primary key (id)

);
