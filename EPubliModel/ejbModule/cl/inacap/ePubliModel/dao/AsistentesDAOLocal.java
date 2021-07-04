package cl.inacap.ePubliModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.ePubliModel.dto.Asistente;

@Local
public interface AsistentesDAOLocal {

	void save(Asistente asistente);
	void guardar (Asistente a);
	List<Asistente> getAll();
	void delete(Asistente asistente);
	List<Asistente> filterByName(String rut);
}
