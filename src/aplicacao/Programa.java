package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.modelo.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: DATA do Check-out deve ser depois da DATA do check-in!");
		}
		else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
		
		
		System.out.println();
		System.out.println("Digite a data atualizada da reserva: ");
		System.out.print("Check-in data (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
		


		String erro = reserva.dataAtualizacao(checkIn, checkOut);
		
		if(erro !=null) {
			System.out.println("Erro na reserva: "+ erro);
		}
		else {
			System.out.println("Reserva: "+ reserva);
		}
		


		}			
		sc.close();
	}

}
