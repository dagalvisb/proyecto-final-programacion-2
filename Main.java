
import Colegio.Alumno;
import Colegio.BaseDatos;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos();

        while (true) {
            String[] opciones = {"Registrar Alumno", "Insertar Curso", "Consultar Alumnos", "Salir"};
            int eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0: 
                    String nombre = JOptionPane.showInputDialog("Nombre del alumno:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del alumno:"));
                    int cursoId = Integer.parseInt(JOptionPane.showInputDialog("ID del curso:"));
                    bd.insertarAlumno(nombre, edad, cursoId);
                    JOptionPane.showMessageDialog(null, "Alumno registrado exitosamente");
                    break;

                case 1: 
                    String nombre1 = JOptionPane.showInputDialog("Nombre del Curso:");
                    String descripcion = JOptionPane.showInputDialog("Descripción del Curso:");
                    bd.insertarCurso(nombre1, descripcion);
                    JOptionPane.showMessageDialog(null, "Curso registrado exitosamente");
                    break;

                case 2: 
                    List<Alumno> alumnos = bd.obtenerAlumnos();
                    StringBuilder lista = new StringBuilder("Alumnos registrados:\n");
                    for (Alumno a : alumnos) {
                        lista.append("ID: ").append(a.getId()).append
                                    (", Nombre: ").append(a.getNombre()).append
                                    (", Edad: ").append(a.getEdad()).append
                                    (", Curso ID: ").append(a.getCursoId()).append
                                    ("\n");
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;

                case 3: 
                    System.exit(0);
            }
        }
    }
}