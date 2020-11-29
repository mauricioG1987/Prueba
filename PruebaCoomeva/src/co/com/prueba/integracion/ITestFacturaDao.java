package co.com.prueba.integracion;


import co.com.prueba.modelo.TestFactura;

public interface ITestFacturaDao {
	
	public TestFactura crearFactura(TestFactura factura) throws Exception;
	
	public int consultarMaxID() throws Exception;
	
	

}
