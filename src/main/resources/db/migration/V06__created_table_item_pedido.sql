CREATE TABLE item_pedido (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  pedido_id int(11) DEFAULT NULL,
  produto_id int(11) DEFAULT NULL,
  feito_em TIMESTAMP NULL DEFAULT NOW()
);

INSERT INTO item_pedido (id, pedido_id, produto_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 4),
(4, 1, 5),
(5, 1, 6),
(6, 2, 7),
(7, 2, 2),
(8, 2, 6),
(9, 2, 8),
(10, 2, 11),
(11, 2, 10);
