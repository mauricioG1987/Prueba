package co.com.prueba.modelo;
// Generated Nov 27, 2020 11:18:46 PM by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TestCliente generated by hbm2java
 */
public class TestCliente implements java.io.Serializable {

	private Integer idCliente;
	private int identifiacion;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String email;
	private Set testFacturas = new HashSet(0);

	public TestCliente() {
	}

	public TestCliente(int identifiacion, String nombres, String apellidos, String direccion) {
		this.identifiacion = identifiacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	public TestCliente(int identifiacion, String nombres, String apellidos, String direccion, String telefono,
			String email, Set testFacturas) {
		this.identifiacion = identifiacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.testFacturas = testFacturas;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdentifiacion() {
		return this.identifiacion;
	}

	public void setIdentifiacion(int identifiacion) {
		this.identifiacion = identifiacion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getTestFacturas() {
		return this.testFacturas;
	}

	public void setTestFacturas(Set testFacturas) {
		this.testFacturas = testFacturas;
	}

}
