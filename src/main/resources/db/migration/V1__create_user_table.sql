create schema if not exists users;

create table users.user(
	id bigserial primary key,
	nome varchar(50) not null,
	cpf varchar(11) not null,
	endereco varchar(50) not null,
	email varchar(50) not null,
	telefone varchar(10) not null,
	data_cadastro timestamp not null
);