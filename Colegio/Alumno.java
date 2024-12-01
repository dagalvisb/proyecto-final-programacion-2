package Colegio;

public class Alumno {
    private int id;
    private String nombre;
    private int edad;
    private int cursoId;

    public Alumno(int id, String nombre, int edad, int cursoId) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cursoId = cursoId;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public int getEdad() { 
        return edad; 
    }
    public void setEdad(int edad) { 
        this.edad = edad; 
    }

    public int getCursoId() { 
        return cursoId; 
    }
    public void setCursoId(int cursoId) { 
        this.cursoId = cursoId; 
    }
}