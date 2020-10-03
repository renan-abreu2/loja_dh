CREATE TABLE endereco (
  	id int(11) PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(190) NOT NULL,
    cep	VARCHAR(100),
    cidade VARCHAR(100),
    cliente_id int(11) NOT NULL
);

INSERT INTO endereco (id, rua, cep, cidade, cliente_id) VALUES
(1, 'Rua do cliente 1', 'CEP do cliente 1', 'Cidade do cliente 1', 1),
(2, 'Rua do cliente 2', 'CEP do cliente 2', 'Cidade do cliente 2', 2),
(3, 'Rua do cliente 3', 'CEP do cliente 3', 'Cidade do cliente 3', 3),
(4, 'Rua do cliente 4', 'CEP do cliente 4', 'Cidade do cliente 4', 4),
(5, 'Rua do cliente 5', 'CEP do cliente 5', 'Cidade do cliente 5', 5);