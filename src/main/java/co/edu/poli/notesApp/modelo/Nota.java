
package co.edu.poli.notesApp.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String id;
    private String titulo, descripcion, contenido , fecha;

    public Nota(String id, String Titulo, String Descripcion, String Contenido, String Fecha) {
        this.id = id;
        this.titulo = Titulo;
        this.descripcion = Descripcion;
        this.contenido = Contenido;
        this.fecha = Fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String Titulo) {
        this.titulo = Titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String Fecha) {
        this.fecha = Fecha;
    }
    
    
    
}
