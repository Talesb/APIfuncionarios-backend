create database funcionarios;
use funcionarios;

create table FUNCIONARIO(
	ID int not null auto_increment PRIMARY KEY,
	NOME varchar(100) not null,
    IDADE int not null,
    CARGO varchar(200) not null
);

create table OPER_LOG(
	ID  int not null auto_increment PRIMARY KEY,
    DATAEVENTO date not null,
    OPERACAO varchar(50) not null,
    FUNCIONARIOID int
);