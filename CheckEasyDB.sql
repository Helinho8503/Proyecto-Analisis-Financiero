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