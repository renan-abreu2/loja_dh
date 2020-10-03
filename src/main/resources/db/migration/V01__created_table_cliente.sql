CREATE TABLE cliente (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(150) NOT NULL,
  cpf varchar(14) DEFAULT NULL,
  telefone varchar(11) DEFAULT NULL
);
INSERT INTO cliente (id, nome, cpf, telefone) VALUES
(1, 'Robson Santos', '030.030.032-30', '15-99613534'),
(2, 'Lasgo de Almeida', '333.333.333-33', '11-99996666'),
(3, 'Alizee do Prado', '336.633.623-33', '12-99996666'),
(4, 'Adele da Silva', '002.220.212-22', '13-99996666'),
(5, 'Katty Perry Alves', '223.322.123-30', '14-99996666');