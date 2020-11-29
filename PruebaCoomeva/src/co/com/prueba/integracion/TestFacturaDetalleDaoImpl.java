package co.com.prueba.integracion;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.prueba.modelo.TestFacturaDetalle;

public class TestFacturaDetalleDaoImpl extends BaseHibernateDAO implements ITestFacturaDetalleDao {
	private static final Logger log = LoggerFactory.getLogger(TestFacturaDetalleDaoImpl.class);
	
	@Override
	public void crearFactura(TestFacturaDetalle facturaDetalle) throws Exception {
		

		log.debug("Registrando  TestFactura");
		try {
			
			Transaction transaction = HibernateSessionFactory.getSession().beginTransaction();
			getSession().save(facturaDetalle);

			transaction.commit();
			HibernateSessionFactory.getSession().close();
						
			
			log.debug("Registro TestFactura con exito");
		} catch (Exception ex) {
			log.error("Registro TestFactura fallo", ex);
			throw ex;
		}
		
		
	}

}
