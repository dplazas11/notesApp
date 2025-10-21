
package co.edu.poli.notesApp.modelo;

import jakarta.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notasid")    
    private Long notasid;
    
    @Column(name = "titulo", nullable = false)
    private String titulo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "contenido")
    private String contenido; 
    
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    public Nota(){
        
    }
    public Nota(Long id, String Titulo, String Descripcion, String Contenido, Date Fecha) {
        this.notasid = id;
        this.titulo = Titulo;
        this.descripcion = Descripcion;
        this.contenido = Contenido;
        this.fecha = Fecha;
    }

    public Long getNotasid() {
        return notasid;
    }

    public void setNotasid(Long notasid) {
        this.notasid = notasid;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date Fecha) {
        this.fecha = Fecha;
    }
    
    
    
}
