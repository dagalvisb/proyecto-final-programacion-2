package Colegio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
    private Connection connection;

    public BaseDatos() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/colegio", "postgres", "Danny1053814829");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertarAlumno(String nombre, int edad, int cursoId) {
        try {
            String query = "INSERT INTO alumnos (nombre_alumno, edad_alumno, id_curso_alumno) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setInt(3, cursoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarCurso(String nombre, String descripcion) {
        try {
            String query = "INSERT INTO cursos (nombre_curso, descripcion_curso) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String query = "SELECT * FROM alumnos";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                alumnos.add(new Alumno(rs.getInt("id_alumno"), rs.getString("nombre_alumno"), rs.getInt("edad_alumno"), rs.getInt("id_curso_alumno")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}