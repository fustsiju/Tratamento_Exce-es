package app;

import java.util.Scanner;

import entidadesfix.Conta;
import excecoes.DomainException;

public class Fixacao {
	public static void main(String args[]) {
		Scanner num = new Scanner(System.in);
		
		System.out.println("Insira os dados da conta: ");
		System.out.print("Numero: ");
		int n = num.nextInt();
		System.out.print("Nome: ");
		String nome = num.next();
		System.out.print("Saldo inicial: ");
		double saldo = num.nextDouble();
		System.out.print("Limite saque: ");
		double limiteSaque = num.nextDouble();
		Conta conta = new Conta(n, nome, saldo, limiteSaque);
		System.out.println("");
		System.out.print("Insira a quantia para saque: ");
		double quantia = num.nextDouble();
		try {
			conta.saque(quantia);
			System.out.printf("Novo saldo %.2f", conta.getSaldo());
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		num.close();
	}
}
