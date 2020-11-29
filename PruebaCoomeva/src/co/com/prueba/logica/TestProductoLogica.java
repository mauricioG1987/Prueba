package co.com.prueba.logica;

import java.util.List;


import co.com.prueba.integracion.TestProductoDaoImpl;

import co.com.prueba.modelo.TestProducto;

public class TestProductoLogica implements ITestProductoLogica {

	@Override
	public List<TestProducto> consultarProductosConStock() throws Exception {
		
		
		TestProductoDaoImpl productoDao = new TestProductoDaoImpl();
		
		List<TestProducto> lista = productoDao.listarProductosConStock();

		return lista;
		
		
	}

	@Override
	public void modificarProducto(TestProducto producto) throws Exception {
		
		TestProductoDaoImpl productoDao = new TestProductoDaoImpl();
		
		productoDao.modificarProducto(producto);
		
	}

	@Override
	public TestProducto consultarProductoPorCodigo(String codigo) throws Exception {
		
		TestProductoDaoImpl productoDao = new TestProductoDaoImpl();
		
		TestProducto producto = productoDao.consultarProductoPorCodigo(codigo);
		
		return producto;
	}

	@Override
	public boolean validarExistenciaProducto(TestProducto producto, int cantidad) throws Exception {
		
		TestProducto testProducto = consultarProductoPorCodigo(producto.getCodigo());
		
		if(cantidad <= testProducto.getStock() ) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
