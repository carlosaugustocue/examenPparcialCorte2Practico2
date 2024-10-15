package org.nerv.repository;

import org.nerv.domain.Barberia;
import java.util.List;

public interface BarberiaRepository {
    void guardar(Barberia barberia);
    Barberia obtenerPorId(Long id);
    List<Barberia> obtenerTodos();
    void actualizar(Barberia barberia);
    void eliminar(Long id);
}
