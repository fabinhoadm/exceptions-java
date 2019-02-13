package entidades.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecao.modelo.ExcecaoDominio;

public class Reserva {
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut)  {
		if(!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("Erro na reserva: DATA do Check-out deve ser depois da DATA do check-in!");
		}
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void dataAtualizacao(Date checkIn, Date checkOut)  {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new ExcecaoDominio( "As datas de reserva para atualização devem ser datas futuras!");
		}
		 if(!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("Erro na reserva: DATA do Check-out deve ser depois da DATA do check-in!");
		}
		
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numQuarto 
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites! ";
				
	}
}
