package cl.inacap.ePubliModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.ePubliModel.dto.Asistente;

/**
 * Session Bean implementation class AsistentesDAO
 */
@Stateless
@LocalBean
public class AsistentesDAO implements AsistentesDAOLocal {

	private static List<Asistente> asistentes = new ArrayList<>();

	@Override
	public void save(Asistente asistente) {
		// TODO Auto-generated method stub
		asistentes.add(asistente);
	}

	@Override
	public List<Asistente> getAll() {
		// TODO Auto-generated method stub
		return asistentes;
	}

	@Override
	public void delete(Asistente asistente) {
		// TODO Auto-generated method stub
		asistentes.remove(asistente);
	}

	@Override
	public List<Asistente> filterByName(String rut) {
		
		return asistentes.stream().filter(a->a.getRut().contains(rut)).collect(Collectors.toList());
	}

}
