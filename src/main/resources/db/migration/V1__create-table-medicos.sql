-- SCRIPT PARA MYSQL
--Create table medicos(
--    id bigint not null auto_increment,
--    nome varchar(100) not null,
--    email varchar(100) not null unique,
--    crm varchar(100) not null unique,
--    especialidade varchar(100) not null,
--    telefone varchar(20) not null,
--    logradouro varchar(100) not null,
--    bairro varchar(100) not null,
--    cep varchar(9) not null,
--    complemento varchar(100),
--    numero varchar(20) not null,
--    uf varchar(2) not null,
--    cidade varchar(100) not null,
--
--    primary key(id)
--);
-- SCRIPT PARA POSTGRES, CUIDADO AO CRIAR O NOME DA PASTA (DEVE SER -> db/migration) se for db/migrations nao funciona
CREATE TABLE medicos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    crm VARCHAR(100) NOT NULL UNIQUE,
    especialidade VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cidade VARCHAR(100) NOT NULL
);