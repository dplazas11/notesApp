
package co.edu.poli.notesApp.repositorio;

import java.util.ArrayList;


public interface Operacion <T>{
    String insertar(T entidad);  
    String eliminar(String id); 
    String actualizar(T entidad);
    T selectId(String id);
    ArrayList<T> selectAll();
}
