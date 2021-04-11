package br.com.fuctura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
	
	public static void saida(String texto) {
		System.out.println(texto);
	}
	
	public static String lerEntradaUsuario() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
}
