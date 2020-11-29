package co.com.prueba.vista;



import java.util.List;

import co.com.prueba.logica.ITestClienteLogica;
import co.com.prueba.logica.ITestFacturaDetalleLogica;
import co.com.prueba.logica.ITestFacturaLogica;
import co.com.prueba.logica.ITestProductoLogica;
import co.com.prueba.logica.TestClienteLogica;
import co.com.prueba.logica.TestFacturaDetalleLogica;
import co.com.prueba.logica.TestFacturaLogica;
import co.com.prueba.logica.TestProductoLogica;
import co.com.prueba.modelo.TestCliente;
import co.com.prueba.modelo.TestFactura;
import co.com.prueba.modelo.TestFacturaDetalle;
import co.com.prueba.modelo.TestProducto;





public class BusinessDelegator {
	
	public static TestCliente consultarCliente(int identificacion)throws Exception{
		ITestClienteLogica clienteLogica = new TestClienteLogica();
		return clienteLogica.consultarClientePorIdentificacion(identificacion);
		
	
	}
	
	public static List<TestProducto> consultarProductosConStock() throws Exception{
		ITestProductoLogica productoLogica = new TestProductoLogica();
		return productoLogica.consultarProductosConStock();
	}
	
	public static TestFactura registrarFactura(TestFactura factura) throws Exception{
		ITestFacturaLogica facturaLogica = new TestFacturaLogica();
		return facturaLogica.crearFactura(factura);
	}
	
	public static void registrarFacturaetalle(TestFacturaDetalle factura)throws Exception{
		ITestFacturaDetalleLogica facturaLogica = new TestFacturaDetalleLogica();
		facturaLogica.crearFacturaDetalle(factura);
		
	}
	
	public static boolean validarExistenciaProducto(TestProducto producto, int cantidad) throws Exception{
		ITestProductoLogica productoLogica = new TestProductoLogica();
		return productoLogica.validarExistenciaProducto(producto, cantidad);
	}
	
	public static void modificarProducto(TestProducto producto) throws Exception{
		ITestProductoLogica productoLogica = new TestProductoLogica();
		productoLogica.modificarProducto(producto);
	}

	
	
	public static void registrarCliente(TestCliente cliente)throws Exception{
		ITestClienteLogica clienteLogica = new TestClienteLogica();
		clienteLogica.crearCliente(cliente);
		
	
	}

	

}
