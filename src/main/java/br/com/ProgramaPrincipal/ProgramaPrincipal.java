package br.com.ProgramaPrincipal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.qm.carro.DAO.CarroDAO;
import br.com.qm.carro.pojo.CarroPojo;

public class ProgramaPrincipal {

	public static void adicionaCarro(CarroDAO carroDAO, Scanner teclado) {
		teclado.nextLine();
		System.out.println("Digite a Placa do carro:");
		String placa = teclado.nextLine();
		System.out.println("Digite a cor: ");
		String cor = teclado.nextLine();
		System.out.println("Digite a marca do carro: ");
		String marca = teclado.nextLine();
		System.out.println("Digite o modelo do carro: ");
		String modelo = teclado.nextLine();
		
		CarroPojo carro = new CarroPojo(placa, cor, marca, modelo);
		
		try {
			
			carroDAO.insereCarro(carro);
			System.out.println("Carro inserido com sucesso!");
			
		}catch(SQLException e) {
		
			System.err.println("Erro ao inserir carro!");
			System.err.println(e.getMessage());
			
		}
		
	}
	
	public static void removeCarro(CarroDAO carroDAO, Scanner teclado) {
		teclado.nextLine();
		System.out.println("Digite a Placa para Removido carro:");
		String placa = teclado.nextLine();
		
		try {
			
			carroDAO.removeCarro(placa);
			System.out.println("Carro Removida!");
			
		}catch(SQLException e) {
		
			System.err.println("Erro ao remove carro!");
			System.err.println(e.getMessage());
			
		}
	}
	
	public static void consultarCarro(CarroDAO carroDAO, Scanner teclado) {
		teclado.nextLine();
		System.out.println("Digite a Placa do carro: ");
		String placa = teclado.nextLine();
		
		carroDAO.consultaCarro(placa);
		
	}
	
	public static void listarCarros(CarroDAO carroDAO){
		try{
			
			List<CarroPojo> carros = carroDAO.listaCarros();
			
			for(CarroPojo carro : carros) {
				System.out.println(carro);
			}
		}catch(SQLException e) {
			System.err.println("Erro ao consultar carro");
			System.err.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
		CarroDAO carroDAO = new CarroDAO();
		Scanner teclado = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("╔═══════════════════════╗");
			System.out.println("║♠♠♠♠♠♠♠♠ CARRO ♠♠♠♠♠♠♠♠║");
			System.out.println("║ 1 - Adiciona carro    ║");
			System.out.println("║ 2 - Remove carro      ║");
			System.out.println("║ 3 - Consultar Carro   ║");
			System.out.println("║ 4 - Listar carros     ║");
			System.out.println("║ 0 - Fechar            ║");
			System.out.println("╚═══════════════════════╝");
			System.out.println("Digite o número da opção desejada: ");
			opcao = teclado.nextInt();
			
			for (int i = 0; i < 50; ++i) { System.out.println ();}
			switch (opcao) {
			case 1:{
				System.out.println("►►► Adiciona Carro ◄◄◄");
				int sair = 0;
				do {
					adicionaCarro(carroDAO, teclado);
					
					System.out.println("Deseja finalizar a Cadastro:\n Digite 0- Fechar ou 1- Continuar Cadastrando");
					sair = teclado.nextInt();
				}while(sair !=0);
				System.out.println("Cadastro Fechado!");
				break;
			}
			case 2:{
				System.out.println("►►► Remove Carro ◄◄◄");
				int sair = 0;
				do {
					removeCarro(carroDAO, teclado);
					System.out.println("Deseja remover outro carro:\n Digite 0- Fechar ou 1- Continuar Cadastrando");
					sair = teclado.nextInt();
				}while(sair !=0);
				System.out.println("Fechado!");
				break;
			}
			case 3:{
				System.out.println("►►► Consultar Carro ◄◄◄");
				int sair = 0;
				do {
					consultarCarro(carroDAO, teclado);
					System.out.println("Deseja consultar carro:\n Digite 0- Fechar ou 1- Continuar Cadastrando");
					sair = teclado.nextInt();
				}while(sair !=0);
				System.out.println("Consulta Fechada!");
				break;
			}
			case 4:{
				System.out.println("►►► Listar Carros ◄◄◄");
				int sair = 0;
				do {
					listarCarros(carroDAO);
					System.out.println("Deseja finalizar a Lista:\n Digite 0- Fechar ou 1- Continuar Cadastrando");
					sair = teclado.nextInt();
				}while(sair !=0);
				System.out.println("Lista Fechada!");
				break;
			}
			default:
				System.err.println("Opção Invalida!");
				break;
			}				
			
		}while(opcao != 0);
		
		teclado.close();
	}

}
