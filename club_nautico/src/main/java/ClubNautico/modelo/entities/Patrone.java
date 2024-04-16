package ClubNautico.modelo.entities;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the patrones database table.
 * 
 */
@Entity
@Table(name="patrones")
@NamedQuery(name="Patrone.findAll", query="SELECT p FROM Patrone p")
public class Patrone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_patron")
	private int idPatron;

	private String apellidos;

	private String nombre;

	//bi-directional many-to-one association to Salida
	@OneToMany(mappedBy="patrones")
	private List<Salida> salidas;

	public Patrone() {
	}

	public int getIdPatron() {
		return this.idPatron;
	}

	public void setIdPatron(int idPatron) {
		this.idPatron = idPatron;
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

	public List<Salida> getSalidas() {
		return this.salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	public Salida addSalida(Salida salida) {
		getSalidas().add(salida);
		salida.setPatrones(this);

		return salida;
	}

	public Salida removeSalida(Salida salida) {
		getSalidas().remove(salida);
		salida.setPatrones(null);

		return salida;
	}

}