package co.com.prueba.integracion;

import co.com.prueba.modelo.TestFactura;
import co.com.prueba.modelo.TestFacturaDetalle;

public interface ITestFacturaDetalleDao {
	
	public void crearFactura(TestFacturaDetalle facturaDetalle) throws Exception;

}
