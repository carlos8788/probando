create database trabajo_integrador;

use trabajo_integrador;
create table USUARIO (
	id bigint primary key auto_increment,
    nombre varchar(100) not null,
	apellido varchar(100) not null,
    telefono varchar(20) not null,
    email varchar(100) not null,
    is_admin bit default 0 -- 0 == false ; 1 == true
);

use trabajo_integrador;
create table DOMICILIO (
	id bigint primary key auto_increment,
	calle varchar (100) not null,
    numero int (100) not null,
    lote bigint (100) null,
    manzana varchar (50) null,
    edificio int (100) null,
    departamento int (100) null,
    piso int (100) null,
    referencias varchar (150) null,
    idUsuario bigint,
    foreign key (idUsuario) references USUARIO(id) ON DELETE CASCADE
);

-- INSERT DE USUARIO
INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Alberto', 'Lopéz', '3875412987', 'beto123@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Clara', 'Delgado', '3874256987', 'clarita567d@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Marta', 'Ruiz', '3874123456', 'martaruiz01@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Juan', 'Perez', '38754789456', 'juancho9@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('María', 'Lopéz', '3875987321', 'mari_96@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Nina', 'Cruz', '3876123456', 'ninacruz86@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Horacio', 'Cajal', '3874285637', 'horace25@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Noemi', 'Guanca', '3875963852', 'noemi_345@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Cinthia', 'Marinez', '3874326598', 'lacin_89@gmail.com');

INSERT INTO USUARIO (nombre, apellido, telefono, email)
VALUES ('Carina', 'Grey', '3875147258', 'cari_hermosa@gmail.com');

-- INSERT DE DOMICILIO
INSERT INTO DOMICILIO (calle, numero, idUsuario)
VALUES ('Siempre Viva', 12345, 1);

INSERT INTO DOMICILIO (calle, numero, edificio, departamento, piso, idUsuario)
VALUES ('Perú', 569, 21, 11, 3, 2);

INSERT INTO DOMICILIO (calle, numero, lote, manzana, referencias, idUsuario)
VALUES ('Sin nombre', 00, 24,'E', 'Barrio San Francicsco', 3 );

INSERT INTO DOMICILIO (calle, numero, idUsuario)
VALUES ('San Martin', 860, 4);

INSERT INTO DOMICILIO (calle, numero, edificio, departamento, piso, idUsuario)
VALUES ('Perú', 695, 15, 2, 0, 5);

INSERT INTO DOMICILIO (calle, numero, lote, manzana, referencias, idUsuario)
VALUES ('Gorriti', 00, 12,'H', 'Barrio San Francicsco', 6 );

INSERT INTO DOMICILIO (calle, numero, idUsuario)
VALUES ('Siempre Viva', 12895, 6);

INSERT INTO DOMICILIO (calle, numero, edificio, departamento, piso, idUsuario)
VALUES ('Perú', 569, 21, 15,3,7);

INSERT INTO DOMICILIO (calle, numero, idUsuario)
VALUES ('Siempre Viva', 12456,8);

INSERT INTO DOMICILIO (calle, numero, edificio, departamento, piso, idUsuario)
VALUES ('Perú', 600,30,10,2,9);

INSERT INTO DOMICILIO (calle, numero, idUsuario)
VALUES ('Siempre Viva', 123458,10);

-- SELECT DE TODOS LOS DOMICILIOS DE UN USARIO
SELECT * FROM USUARIO AS U
INNER JOIN DOMICILIO AS D
ON U.id=D.idUsuario
ORDER BY U.id;
-- GROUP BY U.id
-- WHERE U.id=6;

-- SELECT DE TODOS LOS DOMICILIOS DE UN USARIO
SELECT 
	U.id, 
    U.nombre, 
    U.apellido, 
    U.telefono, 
    U.email, 
    D.id AS idDom, 
    D.calle, 
    D.numero, 
    D.lote, 
    D.manzana, 
    D.edificio, 
    D.departamento, 
    D.piso, 
    D.idUsuario 
FROM USUARIO AS U
INNER JOIN DOMICILIO AS D
ON U.id=D.idUsuario
ORDER BY U.id;

 
