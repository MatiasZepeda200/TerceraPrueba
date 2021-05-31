package cl.inacap.ePubliApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.ePubliModel.dao.AsistentesDAOLocal;
import cl.inacap.ePubliModel.dto.Asistente;

/**
 * Servlet implementation class AgregarAsistenteController
 */
@WebServlet("/AgregarAsistenteController.do")
public class AgregarAsistenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private AsistentesDAOLocal asistentesDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarAsistenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/agregarAsistente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> errores = new ArrayList<>();
		
		String normal = request.getParameter("rut-txt").trim();
		String verificador = request.getParameter("verificador-txt").trim();
		String rut = normal+"-"+verificador;
		if (rut.length()<= 9) {
			errores.add("Ingrese un rut valido");
		}
		if(rut.length()>= 11) {
			errores.add("Ingrese un rut real");
		}
		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {
			errores.add("Ingrese un nombre");
		}
		String apellido = request.getParameter("apellido-txt").trim();
		if (apellido.isEmpty()) {
			errores.add("Ingresa un apellido");
		}
		String edadTxt = request.getParameter("edad-txt").trim();
		int edad = 0;
		try {
			edad=Integer.parseInt(edadTxt);
		} catch (Exception ex) {
			errores.add("Ingrese una edad numerica");
		}
		if (edad < 17) {
			errores.add("Ingrese una edad mayor o igual a 18");
		}
		String empresa = request.getParameter("empresa-txt").trim();
		if (empresa.isEmpty()) {
			errores.add("Ingrese una empresa");
		}
		if (empresa.length() <= 5) {
			errores.add("Ingrese un nombre de largo mayor que 5");
		}
		String estado = request.getParameter("estado-select").trim();
		if (estado.isEmpty()) {
			errores.add("Escoga un estado");
		}
		String region = request.getParameter("region-select").trim();
		if (region.isEmpty()) {
			errores.add("Escoga una region");
		}
		
		if (errores.isEmpty()) {
			Asistente asistente = new Asistente();
			asistente.setRut(rut);
			asistente.setNombre(nombre);
			asistente.setApellido(apellido);
			asistente.setEdad(edad);
			asistente.setEmpresa(empresa);
			asistente.setEstado(estado);
			asistente.setRegion(region);
			asistentesDAO.save(asistente);
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("VerAsistenteController.do");
			rd.forward(request, response);
		}else {
			request.setAttribute("errores",errores);
		}
		
		doGet(request, response);
	}

}
