package co.com.prueba.integracion;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.prueba.modelo.TestFactura;


public class TestFacturaDaoImpl extends BaseHibernateDAO implements ITestFacturaDao {
	private static final Logger log = LoggerFactory.getLogger(TestFacturaDaoImpl.class);

	@Override
	public TestFactura crearFactura(TestFactura factura) throws Exception {
		
	
		
		log.debug("Registrando  TestFactura");
		try {
			
			Transaction transaction = HibernateSessionFactory.getSession().beginTransaction();
			getSession().save(factura);

			transaction.commit();
			HibernateSessionFactory.getSession().close();
			
			factura.setIdFactura(consultarMaxID());
			
			
			log.debug("Registro TestFactura con exito");
		} catch (Exception ex) {
			log.error("Registro TestFactura fallo", ex);
			throw ex;
		}
		
		return factura;
		
	}

	@Override
	public int consultarMaxID() throws Exception {
		
		
	List<Integer> lista;
		
		log.debug("Consultando id TestFactura");
				
			String queryString = "SELECT max(d.idFactura) FROM TestFactura d";
			Query queryObject = getSession().createQuery(queryString);
			lista = queryObject.list();

			if(lista.isEmpty()) {
				throw new Exception("No se encontraron Factura");
			}
				
			log.debug("Consulta de factura con exito");
	
		return lista.get(0);
		
		
	}

}
