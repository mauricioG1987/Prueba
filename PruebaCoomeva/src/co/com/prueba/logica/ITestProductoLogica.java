package co.com.prueba.logica;

import java.util.List;

import co.com.prueba.modelo.TestProducto;

public interface ITestProductoLogica {
	
	public List<TestProducto> consultarProductosConStock() throws Exception;

	public void modificarProducto(TestProducto producto) throws Exception;
	
	public TestProducto consultarProductoPorCodigo(String codigo) throws Exception;
	
	public boolean validarExistenciaProducto(TestProducto producto, int cantidad) throws Exception;
}
