
package co.edu.poli.notesApp.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class inicio {
    
    @GetMapping("/notesApp")
    public String inicio(){
      return  "inicio";
    }
            
    
}
