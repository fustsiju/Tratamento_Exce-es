package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entidadesP1.Reserva;
import excecoes.DomainException;

public class Programa1 {
	public static void main(String args[]) {
		System.out.println("Iniciando programa de hotelaria!");
		program();
		System.out.println("Encerrando programa de hotelaria!");
	}

	public static void program() {
		Scanner num = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reserva reserva = new Reserva();
		try {
			System.out.print("Insira o numero do quarto: ");
			reserva.setNumeroQuarto(num.nextInt());
			System.out.print("Insira a data de entrada (dd/MM/YYYY): ");
			reserva.setCheckin(sdf.parse(num.next()));
			System.out.print("Insira a data de saida (dd/MM/YYYY): ");
			reserva.setCheckout(sdf.parse(num.next()));

			System.out.println("Reserva: " + reserva);

			System.out.println("Insira as datas atualizadas da reserva: ");
			System.out.print("Insira a data de entrada (dd/MM/YYYY): ");
			reserva.setCheckin(sdf.parse(num.next()));
			System.out.print("Insira a data de saida (dd/MM/YYYY): ");
			reserva.setCheckout(sdf.parse(num.next()));

			reserva.attDatas(reserva.getCheckin(), reserva.getCheckout());
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Erro na inserção da data!");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		num.close();
	}
}
