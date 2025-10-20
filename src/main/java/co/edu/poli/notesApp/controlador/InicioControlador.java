
package co.edu.poli.notesApp.controlador;



import co.edu.poli.notesApp.modelo.Nota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InicioControlador {
    
    @GetMapping("/notesApp")
    public String inicio(Model model){
        Nota nota1 = new Nota ("N001","Lista de compras", 
                                "Compras para apartamento", 
                                 "Comprar Leche, huevos y pan ", "16/10/2025");
        model.addAttribute("nota1",nota1);
        
      return  "inicio";
    }
            
    
}
