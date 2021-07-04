package cl.inacap.ePubliModel.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.ePubliModel.dto.Asistente;
import cl.inacap.ePubliModel.utils.DB;

/**
 * Session Bean implementation class AsistentesDAO
 */
@Stateless
@LocalBean
public class AsistentesDAO implements AsistentesDAOLocal {

	private DB db = new DB();
	private static List<Asistente> asistentes = new ArrayList<>();

	@Override
	public void save(Asistente asistente) {
		try {
			db.conectar();
			String sql = "INSERT INTO asistente (rut, nombre, apellido, edad, empresa, estado, region) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1,asistente.getRut());
			st.setString(2,asistente.getNombre());
			st.setString(3,asistente.getApellido());
			st.setInt(4,asistente.getEdad());
			st.setString(5,asistente.getEmpresa());
			st.setString(6,asistente.getEstado());
			st.setString(7,asistente.getRegion());
			st.executeUpdate();
		} catch (Exception ex) {
			// TODO: handle exception
		}finally {
			db.desconectar();
			
		}
		asistentes.add(asistente);
	}
	public void guardar (Asistente a) {
		try {
			db.conectar();
			String sql = "INSERT INTO asistente (rut, nombre, apellido, edad, empresa, estado, region) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1,a.getRut());
			st.setString(2,a.getNombre());
			st.setString(3,a.getApellido());
			st.setInt(4,a.getEdad());
			st.setString(5,a.getEmpresa());
			st.setString(6,a.getEstado());
			st.setString(7,a.getRegion());
			st.executeUpdate();
		} catch (Exception ex) {
			// TODO: handle exception
		}finally {
			db.desconectar();
			
		}
	}

	@Override
	public List<Asistente> getAll() {
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
