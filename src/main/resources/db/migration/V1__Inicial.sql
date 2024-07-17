CREATE TABLE Curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE Perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    estado VARCHAR(255) NOT NULL,
    autor_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

CREATE TABLE Respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    topico_id BIGINT,
    autor_id BIGINT,
    solucion BOOLEAN,
    FOREIGN KEY (topico_id) REFERENCES Topico(id),
    FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);

CREATE TABLE Usuario_Perfil (
    usuario_id BIGINT,
    perfil_id BIGINT,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (perfil_id) REFERENCES Perfil(id)
);