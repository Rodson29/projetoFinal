DROP DATABASE IF EXISTS SEIXAS_BUS;
CREATE DATABASE SEIXAS_BUS;
USE SEIXAS_BUS;

CREATE TABLE CLIENTE (
IDCLIENTE INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,NOME VARCHAR(100) NOT NULL
,CPF VARCHAR(11)
,TELEFONE VARCHAR(50)
,EMAIL VARCHAR(50)
);

CREATE TABLE PASSAGEM(
IDPASSAGEM INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,IDCLINTE INT
,ORIGEM VARCHAR(100)
,DESTINO VARCHAR(100)
,DATAVIAGEM DATE 
,POLTRONAS VARCHAR(20)
,VALOR DOUBLE 
,TIPO_PGTO VARCHAR(20)
,TITULAR_CARTAO VARCHAR(100)
,NUMERO_CARTAO VARCHAR(100),
FOREIGN KEY (IDCLIENTE) REFERENCES CLIENTE (IDCLIENTE)
);

INSERT INTO CLIENTE (nome, cpf, telefone, mail) VALUES ('Roberto', '01234567890', '11111-1111', 'rob11@bol.com.br');
INSERT INTO CLIENTE (nome, cpf, telefone, mail) VALUES ('Chico', '09876543210', '22222-2222', 'chico99@gmail.com');
INSERT INTO CLIENTE (nome, cpf, telefone, mail) VALUES ('Manolo', '56789001234', '33333-3333', 'badui99@hotmail.com');

INSERT INTO PASSAGEM (idcliente, origem, destino, dataViagem, poltronas, valor, tipo_pgto, titular_cartao, numero_cartao) VALUES (1, 'Florianópolis', 'Blumenau', '2019-06-25', '12', '70.68','cartão credito','Roberto Alves de Lima','6589452811558632');
INSERT INTO PASSAGEM (idcliente, origem, destino, dataViagem, poltronas, valor, tipo_pgto, titular_cartao, numero_cartao) VALUES (4, 'Curitiba', 'Joinville', '2019-10-29', '22', '63.55','cartão débito','André Lofredo Sampaio','6516872811588249');

