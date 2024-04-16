package ClubNautico.modelo.entities;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


/**
 * The persistent class for the amarres database table.
 * 
 */
@Entity
@Table(name="amarres")
@NamedQuery(name="Amarre.findAll", query="SELECT a FROM Amarre a")
public class Amarre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_amarre")
	private int nAmarre;

	private double cuota;

	//bi-directional many-to-one association to Barco
	@OneToMany(mappedBy="amarre")
	private List<Barco> barcos;

	public Amarre() {
	}

	public int getNAmarre() {
		return this.nAmarre;
	}

	public void setNAmarre(int nAmarre) {
		this.nAmarre = nAmarre;
	}

	public double getCuota() {
		return this.cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public List<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

	public Barco addBarco(Barco barco) {
		getBarcos().add(barco);
		barco.setAmarre(this);

		return barco;
	}

	public Barco removeBarco(Barco barco) {
		getBarcos().remove(barco);
		barco.setAmarre(null);

		return barco;
	}

}