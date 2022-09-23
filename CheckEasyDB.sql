CREATE DATABASE checkEasy;

USE checkEasy;

CREATE TABLE usuarios(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(30) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    email VARCHAR(250) NOT NULL,
    clave VARCHAR(30) NOT NULL
);

CREATE TABLE transacciones(
	id_transaccion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    razon VARCHAR(30) NOT NULL,
    monto FLOAT NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    CONSTRAINT FK_UsuarioTransaccion FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id)
);

DESCRIBE usuarios;
DESCRIBE transacciones;

INSERT INTO usuarios(nombres, apellidos, email, clave) VALUES ("miguel", "cubillos","m@gmail.com","A12345");
INSERT INTO usuarios(nombres, apellidos, email, clave) VALUES ("melissa", "morales","mel@gmail.com","B12345");
INSERT INTO usuarios(nombres, apellidos, email, clave) VALUES ("Ana Maria", "Martinez","ma@gmail.com","123478");
INSERT INTO usuarios(nombres, apellidos, email, clave) VALUES ("Dario Antonio", "Soacha","Dantonio@gmail.com","5738568a");
INSERT INTO usuarios(nombres, apellidos, email, clave) VALUES ("Adriana", "Aragon","aragon@gmail.com","325346452");

select * from usuarios;

INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (1, "casa",345.5,"Ingreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (1, "venta",27,"Egreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (2, "sueldo",1024,"Ingreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (3, "sueldo",2000,"Ingreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (3, "renta",1200,"Ingreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (3, "mercado",150,"Egreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (4, "colegio",200,"Egreso");
INSERT INTO transacciones(id_usuario, razon, monto, tipo) VALUES (5, "sueldo",3500,"Ingreso");

select * from transacciones;