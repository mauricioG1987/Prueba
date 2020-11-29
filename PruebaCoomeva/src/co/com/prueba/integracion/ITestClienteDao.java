package co.com.prueba.integracion;

import java.util.List;

import co.com.prueba.modelo.TestCliente;

public interface ITestClienteDao {

	public void crearCliente(TestCliente cliente);
	public void modificarCliente (TestCliente cliente);
	public void eliminarCliente (TestCliente cliente);
	public TestCliente consultarClientePorIdentificacion (int identificacion) throws Exception;
	public List<TestCliente> listarClientes();
	
}
