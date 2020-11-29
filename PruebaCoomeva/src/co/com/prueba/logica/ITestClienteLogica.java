package co.com.prueba.logica;

import co.com.prueba.modelo.TestCliente;

public interface ITestClienteLogica {

	public void crearCliente(TestCliente cliente)throws Exception;

	public TestCliente consultarClientePorIdentificacion(int identificacion) throws Exception;
}
