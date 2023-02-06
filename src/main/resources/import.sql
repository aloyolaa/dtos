INSERT INTO customer (first_name, last_name, email, birth_date, create_date) VALUES ('Alan', 'Loyola', 'aloyolaa@gmail.com', '2002-10-20', NOW());
INSERT INTO customer (first_name, last_name, email, birth_date, create_date) VALUES ('Gabriel', 'Loyola', 'gabriel@gmail.com', '2002-11-20', NOW());
INSERT INTO customer (first_name, last_name, email, birth_date, create_date) VALUES ('Juan', 'Lopez', 'juan@gmail.com', '2002-12-20', NOW());
INSERT INTO customer (first_name, last_name, email, birth_date, create_date) VALUES ('Luis', 'Sanchez', 'luis@gmail.com', '2002-03-20', NOW());
INSERT INTO customer (first_name, last_name, email, birth_date, create_date) VALUES ('Carlos', 'Carranza', 'carlos@gmail.com', '2002-04-20', NOW());

INSERT INTO product (name, price, create_date) VALUES ('Product 1', 0.90, NOW());
INSERT INTO product (name, price, create_date) VALUES ('Product 2', 1.20, NOW());
INSERT INTO product (name, price, create_date) VALUES ('Product 3', 0.50, NOW());
INSERT INTO product (name, price, create_date) VALUES ('Product 4', 0.70, NOW());
INSERT INTO product (name, price, create_date) VALUES ('Product 5', 2.30, NOW());
INSERT INTO product (name, price, create_date) VALUES ('Product 6', 5.20, NOW());
INSERT INTO product (name, price, create_date) VALUES ('Product 7', 4.20, NOW());

INSERT INTO invoice (description, observation, create_date, customer_id) VALUEs ('Invoice 1', 'Observation 1', NOW(), 1);
INSERT INTO invoice (description, observation, create_date, customer_id) VALUEs ('Invoice 2', 'Observation 2', NOW(), 1);
INSERT INTO invoice (description, observation, create_date, customer_id) VALUEs ('Invoice 3', 'Observation 3', NOW(), 2);
INSERT INTO invoice (description, observation, create_date, customer_id) VALUEs ('Invoice 4', 'Observation 4', NOW(), 3);
INSERT INTO invoice (description, observation, create_date, customer_id) VALUEs ('Invoice 5', 'Observation 5', NOW(), 4);
INSERT INTO invoice (description, observation, create_date, customer_id) VALUEs ('Invoice 6', 'Observation 6', NOW(), 5);

INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (2, 1, 1);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (1, 2, 1);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (2, 3, 2);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (3, 4, 2);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (1, 5, 3);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (5, 6, 3);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (3, 7, 4);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (2, 3, 4);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (1, 5, 5);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (4, 2, 6);
INSERT INTO invoice_item (quantity, product_id, invoice_id) VALUES (2, 7, 6);