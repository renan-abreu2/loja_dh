CREATE TABLE produto (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(150) NOT NULL,
  categoria_id int(11) DEFAULT NULL,
  preco float DEFAULT NULL
);

INSERT INTO produto (id, nome, categoria_id, preco) VALUES
(1, 'hotdog', 1, 3),
(2, 'hamburguer', 1, 13),
(3, 'xburger', 1, 13),
(5, 'House Of Burger', 1, 13),
(4, 'xsalada', 1, 12),
(6, 'Mega sanduba', 1, 11.2),
(7, 'X morto de fome', 1, 15.4),
(8, 'Cola cola', 3, 10),
(9, 'Portuguesa especial', 2, 38.5),
(10, 'Mussarela', 2, 25),
(11, 'Calabresa', 2, 25),
(12, 'Fanta', 3, 9.5),
(13, 'Heineken', 5, 9),
(17, 'Bohemia', 5, 9.5);