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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


/**
 * The persistent class for the barcos database table.
 * 
 */
@Entity
@Table(name="barcos")
@NamedQuery(name="Barco.findAll", query="SELECT b FROM Barco b")
public class Barco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_barco")
	private int idBarco;

	@Column(name="n_matricula")
	private String nMatricula;

	private String nombre;

	//bi-directional many-to-one association to Amarre
	@ManyToOne
	@JoinColumn(name="n_amarre")
	private Amarre amarre;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//bi-directional many-to-one association to Salida
	@OneToMany(mappedBy="barco")
	private List<Salida> salidas;

	public Barco() {
	}

	public int getIdBarco() {
		return this.idBarco;
	}

	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}

	public String getNMatricula() {
		return this.nMatricula;
	}

	public void setNMatricula(String nMatricula) {
		this.nMatricula = nMatricula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Amarre getAmarre() {
		return this.amarre;
	}

	public void setAmarre(Amarre amarre) {
		this.amarre = amarre;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Salida> getSalidas() {
		return this.salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	public Salida addSalida(Salida salida) {
		getSalidas().add(salida);
		salida.setBarco(this);

		return salida;
	}

	public Salida removeSalida(Salida salida) {
		getSalidas().remove(salida);
		salida.setBarco(null);

		return salida;
	}

}