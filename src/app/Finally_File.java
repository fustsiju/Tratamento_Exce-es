package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Finally_File {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Fulvio Stefanine\\Desktop\\EHP.txt"); //Passando caminho do arquivo
		Scanner num = null; //Scanner apontando para null
		try {
			num = new Scanner(file); //Tentando apontar o scanner para o arquivo
			while (num.hasNextLine()) {
				System.out.println(num.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Erro ao tentar abrir arquivo: " + e.getMessage());
		} finally {	//Bloco final que deve sempre ser executado
			if (num != null) {
				num.close();
			}
		}
	}
}