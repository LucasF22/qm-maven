package br.com.ProgramaPrincipal;

import java.util.Scanner;

import br.com.qm.carro.DAO.CarroDAO;
import br.com.qm.carro.DAO.CarroDAOHibernate;

public class ProgramaPrincipalHibernate {

	public static void adicionaCarro(CarroDAOHibernate carroDAO, Scanner teclado) {
		teclado.nextLine();
		System.out.println("Digite a Placa do carro:");
		String placa = teclado.nextLine();
		System.out.println("Digite a cor: ");
		String cor = teclado.nextLine();
		System.out.println("Digite a marca do carro: ");
		String marca = teclado.nextLine();
		System.out.println("Digite o modelo do carro: ");
		String modelo = teclado.nextLine();
	}
	
	public static void removeCarro(CarroDAOHibernate carroDAO, Scanner teclado) {
		teclado.nextLine();
		System.out.println("Digite a Placa para Removido carro:");
		String placa = teclado.nextLine();
	}
	
	public static void consultarCarro(CarroDAO carroDAO, Scanner teclado) {
		teclado.nextLine();
		System.out.println("Digite a Placa do carro: ");
		String placa = teclado.nextLine();
	}
	
	public static void listarCarros() {
	
	}
	public static void main(String[] args) {
		CarroDAOHibernate carroDAO = new CarroDAOHibernate();
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
			
			switch (opcao) {
			case 1:{
				System.out.println("►►► Adiciona Carro ◄◄◄");
				int sair = 0;
				do {
					adicionaCarro(carroDAO, teclado);
				}while(sair !=0);
				break;
			}
			case 2:{
				System.out.println("►►► Remove Carro ◄◄◄");
				int sair = 0;
				do {
					removeCarro(carroDAO, teclado);
				}while(sair !=0);
				break;
			}
			case 3:{
				System.out.println("►►► Consultar Carro ◄◄◄");
				int sair = 0;
				do {
					
				}while(sair !=0);
				break;
			}
			case 4:{
				System.out.println("►►► Listar Carros ◄◄◄");
				int sair = 0;
				do {
					
				}while(sair !=0);
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
