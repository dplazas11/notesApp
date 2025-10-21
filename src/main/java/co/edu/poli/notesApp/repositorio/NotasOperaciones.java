
package co.edu.poli.notesApp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.poli.notesApp.modelo.Nota;

@Repository
public interface NotasOperaciones extends JpaRepository<Nota, Long> {
}
