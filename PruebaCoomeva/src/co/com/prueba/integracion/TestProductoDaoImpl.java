package co.com.prueba.integracion;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import co.com.prueba.modelo.TestProducto;

public class TestProductoDaoImpl extends BaseHibernateDAO implements ITestProductoDao {
	private static final Logger log = LoggerFactory.getLogger(TestClienteDaoImpl.class);

	@Override
	public List<TestProducto> listarProductosConStock() throws Exception {
		
		List<TestProducto> lista;
		
		log.debug("Consultando  TestProducto");
				
			String queryString = "SELECT d FROM TestProducto d";
			Query queryObject = getSession().createQuery(queryString);
			lista = queryObject.list();

			if(lista.isEmpty()) {
				throw new Exception("No se encontraron productos en Stock");
			}
				
			log.debug("Consulta de proucto realizada con exito");
	
		return lista;
		
		
	}

	@Override
	public void modificarProducto(TestProducto producto) throws Exception {
		
		
		
		log.debug("Modificando  Producto");
		try {
			
			Transaction transaction = HibernateSessionFactory.getSession().beginTransaction();
			getSession().merge(producto);

			transaction.commit();
			HibernateSessionFactory.getSession().close();
			
			
			
			
			log.debug("Producto modificado con exito");
		} catch (Exception ex) {
			log.error("Modificacion Producto fallo", ex);
			throw ex;
		}
		
		
	}

	@Override
	public TestProducto consultarProductoPorCodigo(String codigo) throws Exception {
		
		
		List<TestProducto> lista;
		
		TestProducto producto;
		
		log.debug("Consultando  TestProducto");
				
			String queryString = "SELECT d FROM TestProducto d WHERE d.codigo = :cod";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("cod", codigo);
			lista = queryObject.list();

			if(lista.isEmpty()) {
				throw new Exception("No se encontraron productos en stock");
			}
				
			producto = lista.get(0);
			
			log.debug("Consulta de proucto realizada con exito");
			
		
	
		return producto;
	}

}
