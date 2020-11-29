package co.com.prueba.logica;



import co.com.prueba.integracion.TestClienteDaoImpl;
import co.com.prueba.modelo.TestCliente;

public class TestClienteLogica implements ITestClienteLogica {

	@Override
	public void crearCliente(TestCliente cliente) throws Exception {
		
		TestClienteDaoImpl clienteDao = new TestClienteDaoImpl();
		
		TestCliente clienteReg = new TestCliente();
		
		clienteReg.setNombres("mauricio");
		clienteReg.setApellidos("Garcia");
		clienteReg.setDireccion("capri");
		clienteReg.setEmail("micorreo");
		clienteReg.setTelefono("12345");
		clienteReg.setIdentifiacion(1130);
		
		clienteDao.crearCliente(clienteReg);
	
		
	}

	@Override
	public TestCliente consultarClientePorIdentificacion(int identificacion) throws Exception {
		
		TestClienteDaoImpl clienteDao = new TestClienteDaoImpl();
	
		TestCliente cliente = clienteDao.consultarClientePorIdentificacion(identificacion);
		
		if(cliente == null) {
			throw new Exception("Cliente con identificacion ["+identificacion+"] no existe");
		}
		
		
		return cliente;
	}



}
