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
 * The persistent class for the socios database table.
 * 
 */
@Entity
@Table(name="socios")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_socio")
	private int idSocio;

	private String apellidos;

	private String nombre;

	//bi-directional many-to-one association to Barco
	@OneToMany(mappedBy="socio")
	private List<Barco> barcos;

	public Socio() {
	}

	public int getIdSocio() {
		return this.idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

	public Barco addBarco(Barco barco) {
		getBarcos().add(barco);
		barco.setSocio(this);

		return barco;
	}

	public Barco removeBarco(Barco barco) {
		getBarcos().remove(barco);
		barco.setSocio(null);

		return barco;
	}

}