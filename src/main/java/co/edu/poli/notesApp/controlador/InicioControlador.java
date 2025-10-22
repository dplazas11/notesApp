package co.edu.poli.notesApp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.poli.notesApp.modelo.Nota;
import co.edu.poli.notesApp.repositorio.NotasOperaciones;
import java.util.List;
import java.util.Optional;

@Controller
public class InicioControlador {

    @Autowired
    private NotasOperaciones notaRepository;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        model.addAttribute("nota", new Nota());
        return "inicio";

    }

    @GetMapping("/listar")
    public String listarNotas(Model model) {
        List<Nota> notas = notaRepository.findAll();
        model.addAttribute("notas", notas);
        return "listar"; // nombre del archivo HTML (listar.html)
    }

    @PostMapping("/inicio")
    public String guardarNota(@ModelAttribute("nota") Nota nota, Model model) {
        try {
            notaRepository.save(nota);
            model.addAttribute("mensaje", "✅ Nota guardada correctamente");
        } catch (Exception e) {
            model.addAttribute("error", "❌ Error al guardar la nota: " + e.getMessage());
        }
        model.addAttribute("nota", new Nota());
        return "inicio";
    }

    // 🟡 Actualizar nota existente
    @PostMapping("/actualizar")
    public String actualizarNota(@ModelAttribute("nota") Nota nota, Model model) {
        if (nota.getNotasid() == null) {
            model.addAttribute("error", "❌ Debes ingresar un ID para actualizar");
        } else if (notaRepository.existsById(nota.getNotasid())) {
            notaRepository.save(nota);
            model.addAttribute("mensaje", "📝 Nota actualizada correctamente");
        } else {
            model.addAttribute("error", "⚠️ No se encontró una nota con ese ID");
        }
        model.addAttribute("nota", new Nota());
        return "verNota";
    }

    // 🔴 Eliminar nota con AJAX
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String eliminarNota(@PathVariable Long id) {
        if (notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
            return "✅ Nota eliminada correctamente";
        } else {
            return "⚠️ No se encontró una nota con ese ID";
        }
    }

    // 🟣 Ver una nota por su ID
    @GetMapping("/verNota/{id}")
    public String verNota(@PathVariable Long id, Model model) {
        Optional<Nota> notaEncontrada = notaRepository.findById(id);

        if (notaEncontrada.isPresent()) {
            model.addAttribute("nota", notaEncontrada.get());
        } else {
            model.addAttribute("nota", new Nota());
            model.addAttribute("error", "⚠️ No se encontró la nota solicitada");
        }

        return "verNota"; // archivo HTML: ver.html
    }
    
    /*
    // 🔍 Buscar nota por ID
    @PostMapping("/buscar")
    public String buscarNota(@ModelAttribute("nota") Nota nota, Model model) {
        if (nota.getNotasid() == null) {
            model.addAttribute("error", "❌ Debes ingresar un ID para buscar");
        } else {
            Optional<Nota> notaEncontrada = notaRepository.findById(nota.getNotasid());
            if (notaEncontrada.isPresent()) {
                model.addAttribute("nota", notaEncontrada.get());
                model.addAttribute("mensaje", "🔎 Nota encontrada");
            } else {
                model.addAttribute("nota", new Nota());
                model.addAttribute("error", "⚠️ No se encontró una nota con ese ID");
            }
        }
        return "inicio";
    }
*/

}
