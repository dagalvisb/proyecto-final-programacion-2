CREATE DATABASE colegio;

CREATE TABLE alumnos (
    id_alumno SERIAL PRIMARY KEY,
    nombre_alimno VARCHAR(100) NOT NULL,
    edad_alumno INT NOT NULL,
    id_curso_alumno INT,
    FOREIGN KEY (id_curso_alumno) REFERENCES cursos(id_curso)
);

CREATE TABLE cursos (
    id_curso SERIAL PRIMARY KEY,
    nombre_curso VARCHAR(100) NOT NULL,
    descripcion_curso TEXT
);

ALTER TABLE alumnos RENAME COLUMN nombre_alimno TO nombre_alumno;

SELECT * FROM cursos;

INSERT INTO cursos (nombre_curso, descripcion_curso) VALUES ("Matematicas", "Nuevo")
