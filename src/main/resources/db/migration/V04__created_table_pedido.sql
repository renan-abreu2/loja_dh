CREATE TABLE pedido (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  cliente_id int(11) DEFAULT NULL,
  data_pedido TIMESTAMP DEFAULT NOW()
);

INSERT INTO pedido (id, cliente_id) VALUES
(1, 1),
(2, 2);