CREATE DATABASE miami_car;
USE miami_car;

CREATE TABLE coches (
    matricula VARCHAR(10) PRIMARY KEY,
    num_bastidor VARCHAR(30) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    color VARCHAR(30),
    tipo_coche VARCHAR(30),
    plazas INT,
    puertas INT,
    combustible ENUM('gasolina','diesel','electrico')
);


CREATE TABLE clientes (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    edad INT,
    telefono VARCHAR(15),
    direccion VARCHAR(100),
    email VARCHAR(100),
    permiso_conduccion VARCHAR(20) UNIQUE NOT NULL
);


CREATE TABLE alquileres (
    id_alquiler INT AUTO_INCREMENT PRIMARY KEY,
    dni_cliente VARCHAR(9),
    matricula_coche VARCHAR(10),
    fecha_inicio DATE,
    dias_alquiler INT,
    precio_dia DECIMAL(8,2),
    precio_final DECIMAL(10,2),
    lugar_devolucion VARCHAR(100),
    deposito_lleno BOOLEAN,
    tipo_seguro ENUM('con_franquicia','sin_franquicia'),
    penalizacion DECIMAL(8,2),
    fecha_devolucion DATE,

    FOREIGN KEY (dni_cliente) REFERENCES clientes(dni),
    FOREIGN KEY (matricula_coche) REFERENCES coches(matricula)
);
INSERT INTO clientes (dni, nombre, apellidos, edad, telefono, direccion, email, permiso_conduccion) VALUES
('12345678A', 'Juan', 'Pérez Gómez', 35, '600123456', 'Calle Mayor 10, Barcelona', 'juan.perez@gmail.com', 'B1234567'),
('23456789B', 'María', 'López Sánchez', 28, '611234567', 'Avenida Diagonal 245, Barcelona', 'maria.lopez@gmail.com', 'B2345678'),
('34567890C', 'Carlos', 'Martínez Ruiz', 42, '622345678', 'Carrer Aragó 120, Barcelona', 'carlos.martinez@gmail.com', 'B3456789'),
('45678901D', 'Laura', 'García Torres', 31, '633456789', 'Passeig de Gràcia 50, Barcelona', 'laura.garcia@gmail.com', 'B4567890'),
('56789012E', 'David', 'Fernández Molina', 55, '644567890', 'Calle Balmes 78, Barcelona', 'david.fernandez@gmail.com', 'B5678901'),
('67890123F', 'Ana', 'Romero Díaz', 26, '655678901', 'Carrer Sants 210, Barcelona', 'ana.romero@gmail.com', 'B6789012'),
('78901234G', 'Jordi', 'Casas Soler', 39, '666789012', 'Carrer Provença 330, Barcelona', 'jordi.casas@gmail.com', 'B7890123'),
('89012345H', 'Marta', 'Navarro Puig', 47, '677890123', 'Avinguda Meridiana 400, Barcelona', 'marta.navarro@gmail.com', 'B8901234'),
('90123456J', 'Sergio', 'Vidal Moreno', 33, '688901234', 'Carrer Marina 90, Barcelona', 'sergio.vidal@gmail.com', 'B9012345'),
('01234567K', 'Clara', 'Ribas Font', 22, '699012345', 'Carrer Gran Via 600, Barcelona', 'clara.ribas@gmail.com', 'B0123456');

INSERT INTO coches VALUES
('1234ABC', 'WBAXX11010A123456', 'Toyota', 'Corolla', 'Blanco', 'Berlina', 5, 4, 'gasolina');

INSERT INTO coches VALUES
('2345BCD', 'VF1RFB00365478912', 'Renault', 'Clio', 'Rojo', 'Compacto', 5, 5, 'diesel');

INSERT INTO coches VALUES
('3456CDE', 'WVWZZZ1JZXW000001', 'Volkswagen', 'Golf', 'Negro', 'Compacto', 5, 5, 'diesel');

INSERT INTO coches VALUES
('4567DEF', 'ZFA3120000J123456', 'Fiat', '500', 'Azul', 'Urbano', 4, 3, 'gasolina');

INSERT INTO coches VALUES
('5678EFG', 'JMZBM123456789012', 'Mazda', 'CX-5', 'Gris', 'SUV', 5, 5, 'diesel');

INSERT INTO coches VALUES
('6789FGH', 'WAUZZZ8V6GA123456', 'Audi', 'A3', 'Blanco', 'Compacto', 5, 5, 'gasolina');

INSERT INTO coches VALUES
('7890GHI', 'WBA8D91020G654321', 'BMW', 'Serie 3', 'Negro', 'Berlina', 5, 4, 'diesel');

INSERT INTO coches VALUES
('8901HIJ', 'VSSZZZ5FZJR123456', 'Seat', 'Ibiza', 'Rojo', 'Compacto', 5, 5, 'gasolina');

INSERT INTO coches VALUES
('9012IJK', 'KNMAT2MT0GP123456', 'Nissan', 'Qashqai', 'Verde', 'SUV', 5, 5, 'electrico');

INSERT INTO coches VALUES
('0123JKL', '5YJSA1E26HF123456', 'Tesla', 'Model 3', 'Blanco', 'Berlina', 5, 4, 'electrico');


select * from clientes;
select * from coches;
