
INSERT INTO specialties VALUES (1, 'radiology') ON CONFLICT DO NOTHING;
INSERT INTO specialties VALUES (2, 'surgery') ON CONFLICT DO NOTHING;
INSERT INTO specialties VALUES (3, 'dentistry') ON CONFLICT DO NOTHING;

INSERT INTO types VALUES (1, 'cat') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (2, 'dog') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (3, 'lizard') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (4, 'snake') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (5, 'bird') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (6, 'hamster') ON CONFLICT DO NOTHING;

INSERT INTO business_owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435') ON CONFLICT DO NOTHING;
INSERT INTO business_owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487') ON CONFLICT DO NOTHING;

INSERT INTO users(username,password,enabled) VALUES ('admin','{noop}admin', true) ON CONFLICT DO NOTHING;

INSERT INTO roles (username, role) VALUES ('admin', 'ROLE_OWNER_ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO roles (username, role) VALUES ('admin', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
