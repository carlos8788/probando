package com.milprogramadores.supermark;

import java.sql.*;

public class ConexionProducto{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/supermark";
	
	static final String USER = "root";
	static final String PASS = "123456";


public static void main(String args[]) throws ClassNotFoundException, SQLException {
	
			Administrador miguel = new Administrador("Miguel", "Paz");
			
			Connection conn = null;
			Statement stmt = null;
			
			Class.forName(JDBC_DRIVER); 
			System.out.println("Conectando a base de datos...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			
			
			
			
		
			
			String sql;
			
			sql = "SELECT * FROM producto";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int ide = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int cantidad = rs.getInt("cantidad");
				
				System.out.println("ID: " + ide);
				System.out.println("Nombre: " + nombre);
				System.out.println("Precio: " + precio);
				System.out.println("Cantidad: " + cantidad);
			}
	
	}
	


}
