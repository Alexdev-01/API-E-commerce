
<!--TABLAS-->
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL
);


CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);


CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE,

    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);


CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE,

    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);


CREATE TABLE pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);


CREATE TABLE detalle_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    producto_id BIGINT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2),
    subtotal DECIMAL(10,2),

    FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);


<!--DATOS DE PRUEBA-->
INSERT INTO categorias (nombre, descripcion) VALUES
('Electrónica', 'Productos electrónicos'),
('Ropa', 'Ropa y accesorios');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria_id) VALUES
('Laptop', 'Laptop potente', 1200, 10, 1),
('Camiseta', 'Camiseta básica', 20, 50, 2);