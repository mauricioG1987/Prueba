package co.com.prueba.logica;


import co.com.prueba.integracion.TestFacturaDaoImpl;
import co.com.prueba.modelo.TestFactura;


public class TestFacturaLogica implements ITestFacturaLogica {

	@Override
	public TestFactura crearFactura(TestFactura factura) throws Exception {
		
		
		TestFacturaDaoImpl facturaDao = new TestFacturaDaoImpl();
		
		return facturaDao.crearFactura(factura);
		
		
		
	}


}
