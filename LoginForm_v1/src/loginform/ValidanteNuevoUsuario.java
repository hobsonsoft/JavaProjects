package loginform;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidanteNuevoUsuario
 */
@WebServlet("/ValidanteNuevoUsuario")
public class ValidanteNuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidanteNuevoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection sqlserver;
		Manejadordb c= new Manejadordb();
        ManejadorMD5 md5 = new ManejadorMD5();
	
			try {
				sqlserver = c.conector("aawyxtumwg8ep9.ca3ssjbhvj3h.us-west-2.rds.amazonaws.com", 5432, "db_credenciales", "javauser", "12345678");
				PreparedStatement inserta=sqlserver.prepareStatement("insert into credenciales(Nombre,Clave)values(?,?)");
				 inserta.setString(1, request.getParameter("nuevo_nombre"));
				 inserta.setString(2, md5.encriptaClave(request.getParameter("nueva_clave")));
				inserta.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
	

}
}
