package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Try_catch {
	public static void main(String[] args) {

		metodo1();

		System.out.println("Fim do programa!");
	}

	public static void metodo1() {
		System.out.println("Inicio do metodo 1!");
		metodo2();
		System.out.println("Fim do metodo 1!");

	}

	public static void metodo2() {
		System.out.println("Inicio do metodo 2!");
		Scanner num = new Scanner(System.in);
		try {
			String[] vect = num.nextLine().split(" "); // split = separar, ao invés de enviar várias strings pode-se
														// enviar
														// uma com os dados separados
			int pos = num.nextInt();
			System.out.println(vect[pos]);

		} catch (ArrayIndexOutOfBoundsException e) { // Numero informado está além do tamanho do array
			System.out.println("Posição inválida!");

		} catch (InputMismatchException e) {
			System.out.println("Erro no valor inserido!");
		}
		System.out.println("Fim do metodo 2!");
		num.close();
	}
}