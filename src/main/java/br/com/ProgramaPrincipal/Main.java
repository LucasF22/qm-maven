package br.com.ProgramaPrincipal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		float x[];
		int n = 8;
		x = new float[n];
		int i;
		int t = 0;
		for(i=0; i<=x.length; i++) {
			x[i] = teclado.nextFloat();
			if(x[i] > 1.80F){
				t = i++; 
			}
		}
		System.out.printf("%d jogadores encontrados", t);
		
	}
	

}
