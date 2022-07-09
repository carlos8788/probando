package Supermark;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class BD {
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String URL_DB = "jdbc:mysql://localhost:3306/trabajo_integrador";
		private static final String USER = "root";
		private static final String PASS = "TiFeJo3017";

		public static void main(String[] args) throws SQLException {
			
			Connection conn = DriverManager.getConnection(URL_DB,USER,PASS);
	        
			java.sql.Statement stm = conn.createStatement();
			
			String names = "U.id, U.nombre, U.apellido, U.telefono, U.email, D.id AS idDom, D.calle, D.numero, D.lote, D.manzana, D.edificio, D.departamento, D.piso, D.idUsuario";
						
			String query = "SELECT " + names + " FROM USUARIO AS U INNER JOIN DOMICILIO AS D ON U.id=D.idUsuario ORDER BY U.id";
						
			ResultSet result = stm.executeQuery(query);
			
			List<Domicilio> domicilios = new ArrayList<Domicilio>();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
//			ResultSetMetaData metadata = (ResultSetMetaData) result.getMetaData();
//		    int columnCount = metadata.getColumnCount();
			while (result.next()) {
				// Datos de usuario
				int idU = result.getInt("id");
			    String nombre = result.getString("nombre"); 
				String apellido = result.getString("apellido");
			    String telefono = result.getString("telefono"); 
			    String email = result.getString("email");
			    
			    // Datos de Domicilio
				int idD = result.getInt("idDom");
				String calle = result.getString("calle");
				int numero = result.getInt("numero");  
				int lote = result.getInt("lote");
				String manzana = result.getString("manzana");
				int edificio = result.getInt("edificio");
				int departamento = result.getInt("departamento");
				int piso = result.getInt("piso");
				int idUsuario = result.getInt("idUsuario");
			    
				Usuario usuario = new Usuario(idU, nombre, apellido, telefono, email);
			    usuarios.add(usuario);
			    
			    Domicilio domicilio = new Domicilio(idD, calle, numero, lote, manzana, edificio, departamento, piso,  idUsuario);
			    domicilios.add(domicilio);
			}
			result.close();
			stm.close();
			conn.close();
			
			List<Usuario> usersWithoutDuplicates =  (usuarios.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Usuario::getId))))).stream().collect(Collectors.toList());;
			System.out.println("***** Datos de usuarios *****");
			System.out.println();
			usersWithoutDuplicates.forEach((u) -> {
				System.out.println("***************************     " + u.getId()+ "     *******************************************");
				System.out.println("IdU: " + u.getId());
				System.out.println("Nombre: " + u.getNombre());
				System.out.println("Apellido: " + u.getApellido());
				System.out.println("Teléfono: " + u.getTelefono());
				System.out.println("Email: " + u.getEmail());
				System.out.println();
				List<Domicilio> domiciliosUsuario = domicilios.stream().filter(domicilio -> new Integer(domicilio.getIdUsuario()).equals(new Integer(u.getId()))).collect(Collectors.toList());
				System.out.println("***** Domicilios registrados: " + domiciliosUsuario.size() + " *****");
				System.out.println();
				domiciliosUsuario.forEach((d) -> {
					System.out.println("IdD: " + d.getId());
					System.out.println("Calle: " + d.getCalle());
					System.out.println("Número: " + d.getNumero());
					System.out.println("Lote: " + d.getLote());
					System.out.println("Manzana: " + d.getManzana());
					System.out.println("Edificio: " + d.getEdificio());
					System.out.println("Departamento: " + d.getDepartamento());
					System.out.println("Piso: " + d.getPiso());
					System.out.println("-------------------------------------------------");
				});
				System.out.println();
				System.out.println("***************************     FIN DE " + u.getId()+ "     *******************************************");
				System.out.println();
			});
  }
}
