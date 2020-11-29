package co.com.prueba.integracion;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.prueba.modelo.TestCliente;

public class TestClienteDaoImpl extends BaseHibernateDAO implements ITestClienteDao  {
	private static final Logger log = LoggerFactory.getLogger(TestClienteDaoImpl.class);
	@Override
	public void crearCliente(TestCliente cliente) {
		
		log.debug("Registrando  TestCliente");
		try {
			
			Transaction transaction = HibernateSessionFactory.getSession().beginTransaction();
			getSession().save(cliente);
			transaction.commit();
			HibernateSessionFactory.getSession().close();
			
			log.debug("Registro cliente con exito");
		} catch (Exception ex) {
			log.error("Registro cliente fallo", ex);
			throw ex;
		}
		
	}
	
	
	

	@Override
	public void modificarCliente(TestCliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCliente(TestCliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestCliente> listarClientes() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public TestCliente consultarClientePorIdentificacion(int identificacion) throws Exception {
		
		TestCliente cliente;
		log.debug("Consultando  TestCliente");
				
			//Transaction transaction = HibernateSessionFactory.getSession().beginTransaction();
			String queryString = "SELECT d FROM TestCliente d WHERE d.identifiacion = :id";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("id", identificacion);
			List<TestCliente> lista = queryObject.list();
			//HibernateSessionFactory.getSession().close();

			if(lista.isEmpty()) {
				throw new Exception("No se encontro cliente con identificacion ["+identificacion+"}");
			}
			
			cliente = lista.get(0);
	
			log.debug("Consulta de cliente realizada con exito");
	
		return cliente;
	}

}
