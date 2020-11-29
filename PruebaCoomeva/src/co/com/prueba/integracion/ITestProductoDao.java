package co.com.prueba.integracion;

import java.util.List;


import co.com.prueba.modelo.TestProducto;

public interface ITestProductoDao {
	
	
	public List<TestProducto> listarProductosConStock() throws Exception;
	
	public void modificarProducto(TestProducto producto) throws Exception;
	
	public TestProducto consultarProductoPorCodigo(String codigo) throws Exception;
	
	
	
	
	
	

}
