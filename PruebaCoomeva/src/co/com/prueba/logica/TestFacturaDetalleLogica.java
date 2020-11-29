package co.com.prueba.logica;


import co.com.prueba.integracion.TestFacturaDetalleDaoImpl;
import co.com.prueba.modelo.TestFacturaDetalle;


public class TestFacturaDetalleLogica implements ITestFacturaDetalleLogica {

	@Override
	public void crearFacturaDetalle(TestFacturaDetalle factura) throws Exception {

		TestFacturaDetalleDaoImpl facturaDao = new TestFacturaDetalleDaoImpl();

		facturaDao.crearFactura(factura);

	}

}
