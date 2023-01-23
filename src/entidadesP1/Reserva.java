package entidadesP1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecoes.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public long Duracao() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void attDatas(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			// throw new IllegalArgumentException("A atualizacao deve ser para datas futuras!"); //Exceção pronta do JAVA
			throw new DomainException("A atualizacao deve ser para datas futuras!"); // Exceção personalizada
		}
		if (!checkout.after(checkin)) {
			// throw new IllegalArgumentException("Data de check-out deve ser posterior a data de check-in!"); //Exceção pronta do JAVA
			throw new DomainException("Data de check-out deve ser posterior a data de check-in!");  // Exceção personalizada
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Quarto: " + numeroQuarto + ", Checkin: " + sdf.format(checkin) + ", Checkout: " + sdf.format(checkout) + ", " + Duracao() + " noites";
	}
	
}
