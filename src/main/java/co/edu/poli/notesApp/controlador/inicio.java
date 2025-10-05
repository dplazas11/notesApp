
package co.edu.poli.notesApp.controlador;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class inicio {
    
    @RequestMapping("/notesApp")
    public String inicio(){
      return  "prueba";
    }
            
    
}
