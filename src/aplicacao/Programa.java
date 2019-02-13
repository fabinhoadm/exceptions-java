package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.modelo.Reserva;
import excecao.modelo.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do Quarto: ");
			int numQuarto = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());



			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
		
		
		System.out.println();
		System.out.println("Digite a data atualizada da reserva: ");
		System.out.print("Check-in data (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());

		
		reserva.dataAtualizacao(checkIn, checkOut);
		System.out.println("Reserva: "+ reserva);
		}
		catch (ParseException e) {
			System.out.println("Data no Formato Invalido!");
		}
		catch(ExcecaoDominio e) {
			System.out.println("Erro na reserva: "+ e.getMessage());
		}


		sc.close();
	}

}
