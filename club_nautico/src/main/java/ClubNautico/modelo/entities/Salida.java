package ClubNautico.modelo.entities;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.sql.Timestamp;


/**
 * The persistent class for the salidas database table.
 * 
 */
@Entity
@Table(name="salidas")
@NamedQuery(name="Salida.findAll", query="SELECT s FROM Salida s")
public class Salida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_salida")
	private int idSalida;

	private String destino;

	@Column(name="fecha_salida")
	private Timestamp fechaSalida;

	//bi-directional many-to-one association to Barco
	@ManyToOne
	@JoinColumn(name="id_barco")
	private Barco barco;

	//bi-directional many-to-one association to Patrone
	@ManyToOne
	@JoinColumn(name="id_patron")
	private Patrone patrones;

	public Salida() {
	}

	public int getIdSalida() {
		return this.idSalida;
	}

	public void setIdSalida(int idSalida) {
		this.idSalida = idSalida;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Timestamp getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Patrone getPatrones() {
		return this.patrones;
	}

	public void setPatrones(Patrone patrones) {
		this.patrones = patrones;
	}

}