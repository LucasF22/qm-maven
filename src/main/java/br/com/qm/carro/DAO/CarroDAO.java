package br.com.qm.carro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.qm.conn.*;
import br.com.qm.carro.pojo.*;

public class CarroDAO {
	
	public Connection conn;
	
	public CarroDAO() {
		this.conn = new Conection().getConnection();
		System.out.println("Conectado!!!");
	}
//	public void mapeia() {
//		
//	}
	
	public boolean insereCarro(CarroPojo CarroPojo) throws SQLException {
		
		String sql = "INSERT INTO carro"
				+ "(placa, cor, marca, modelo) "
				+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, CarroPojo.getPlaca());
		stmt.setString(2, CarroPojo.getCor());
		stmt.setString(3, CarroPojo.getMarca());
		stmt.setString(4, CarroPojo.getModelo());
		
		
		stmt.executeUpdate();
		stmt.close();

		return true;
	}
	
	public List<CarroPojo> listaCarros() throws SQLException {

		List<CarroPojo> carros = new ArrayList<CarroPojo>();

		String sql = "SELECT * FROM carro";

		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			CarroPojo carro = new CarroPojo();
			
			carro.setPlaca(rs.getString("placa"));
			carro.setCor(rs.getString("cor"));
			carro.setMarca(rs.getString("marca"));
			carro.setModelo(rs.getString("modelo"));
			

			carros.add(carro);
		}

		return carros;
	}
	public boolean removeCarro(String placa) throws SQLException {
		
		String sql = "delete from carro "
				+ "where placa = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, placa);
		
		if (stmt.executeUpdate() > 0) {
			return true;
		}
		
		return false;
	}
	
	public CarroPojo consultaCarro(String Placa) {
		
		String sql = "select * from carro "
				+ "where placa = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Placa);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				CarroPojo carro = new CarroPojo(); 
				
				carro.setPlaca(rs.getString("placa"));
				carro.setCor(rs.getString("cor"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				
				return carro;
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao consultar carro");
			System.err.println(e.getMessage());
		}
		
		
		return null; // Pesquisem sobre o Optional.
	}
	

}
