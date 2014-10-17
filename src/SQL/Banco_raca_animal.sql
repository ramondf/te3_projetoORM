create table raca (
    cd_raca integer not null,
    nm_raca varchar(100) not null,
    tp_especie char(1),
    constraint pk_raca primary key (cd_raca)
);

create table animal (
    cd_animal integer not null,
    nm_animal varchar(100) not null,
    dt_nascimento date not null,
    nm_proprietario varchar(100) not null,
    tp_genero char(1) not null,
    cd_raca integer not null,
constraint pk_animal primary key (cd_animal),
constraint fk_raca_animal foreign key (cd_raca) references raca(cd_raca)
);
