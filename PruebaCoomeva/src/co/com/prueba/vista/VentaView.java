package co.com.prueba.vista;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.prueba.modelo.TestCliente;
import co.com.prueba.modelo.TestFactura;
import co.com.prueba.modelo.TestFacturaDetalle;
import co.com.prueba.modelo.TestProducto;
import co.com.prueba.utilidades.Utilidades;

@ViewScoped
@ManagedBean(name="venta")
public class VentaView {
	
	
	private String txtIdentificacionCliente;
	private int intCantidadProducto;
	private TestCliente cliente;
	private List<TestProducto> listaProductos;
	private List<TestProducto> filtroListaProductos;
	private TestProducto productoSeleccionado;
	private TestFacturaDetalle facturaDetalle;
	private List<TestFacturaDetalle> listaFactura;
	private TestFactura factura;
	
	
	public VentaView() {
		try {

			listaFactura = new ArrayList<TestFacturaDetalle>();
			
			Date date=java.util.Calendar.getInstance().getTime();  
			
			factura = new TestFactura();
			factura.setFechaVenta(date);
	
		
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}

	}


	public void consultarCliente(){
		try {

			System.out.println("entro");
			
			if(txtIdentificacionCliente == null || 
					txtIdentificacionCliente.trim().length() == 0) {
				throw new Exception("La identificacion del cliente es obligatoria");
				
			}
			
			if(!Utilidades.esNumerico(txtIdentificacionCliente)) {
				throw new Exception("La identificacion debe ser numerica");
			}
			
			
			cliente = BusinessDelegator.consultarCliente(Integer.parseInt(txtIdentificacionCliente));
		
			
			listaProductos = BusinessDelegator.consultarProductosConStock();
			
			factura.setTestCliente(cliente);
		
			

		} catch (Exception e) {
			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
		     FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	
	
	public void agregarProducto() {
		
		
		
		
		TestFacturaDetalle facturaDetalle = new TestFacturaDetalle();
		
		double total = productoSeleccionado.getValorUnidad().doubleValue()*intCantidadProducto;
		
		facturaDetalle.setCantidad(intCantidadProducto);
		facturaDetalle.setTestProducto(productoSeleccionado);
		facturaDetalle.setValorTotal(BigDecimal.valueOf(total));
		facturaDetalle.setValorUnidad(productoSeleccionado.getValorUnidad());
				
		listaFactura.add(facturaDetalle);
		
		System.out.println(listaFactura.size());
		
		 
		
	}
	
	public double getTotal() {
		
		double total =0;
		
		for (TestFacturaDetalle testFacturaDetalle : listaFactura) {
			total += testFacturaDetalle.getValorTotal().doubleValue();
			
		}
		
		return total;
	}
	
	public void generarFactura() {
		
		
		try {
			
		TestProducto producto;
		
		Date date=java.util.Calendar.getInstance().getTime();  
		
		factura = new TestFactura();
		factura.setFechaVenta(date);
		factura.setTestCliente(cliente);
		
		factura.setValorTotal(BigDecimal.valueOf(getTotal()));
				
		factura = BusinessDelegator.registrarFactura(factura);
		
		for (TestFacturaDetalle testFacturaDetalle : listaFactura) {
			
			producto = testFacturaDetalle.getTestProducto();
			
			if(BusinessDelegator.validarExistenciaProducto(producto, testFacturaDetalle.getCantidad())) {
			
			producto.setStock(producto.getStock() - testFacturaDetalle.getCantidad());
			
			BusinessDelegator.modificarProducto(producto);
				
			}else {
				throw new Exception("No hay stock suficiente para el producto ["+producto.getNombre()+"]") ;
			}
			
		
			
			testFacturaDetalle.setTestFactura(factura);
			BusinessDelegator.registrarFacturaetalle(testFacturaDetalle);
			
			
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}finally {
			listaFactura.clear();
		}
		
	}
	

	public String getTxtIdentificacionCliente() {
		return txtIdentificacionCliente;
	}



	public void setTxtIdentificacionCliente(String txtIdentificacionCliente) {
		this.txtIdentificacionCliente = txtIdentificacionCliente;
	}


	public TestCliente getCliente() {
		return cliente;
	}


	public void setCliente(TestCliente cliente) {
		this.cliente = cliente;
	}


	public List<TestProducto> getListaProductos() {
		return listaProductos;
	}


	public void setListaProductos(List<TestProducto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public TestProducto getProductoSeleccionado() {
		return productoSeleccionado;
	}


	public void setProductoSeleccionado(TestProducto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}


	public TestFacturaDetalle getFacturaDetalle() {
		return facturaDetalle;
	}


	public void setFacturaDetalle(TestFacturaDetalle facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}


	public List<TestFacturaDetalle> getListaFactura() {
		return listaFactura;
	}


	public void setListaFactura(List<TestFacturaDetalle> listaFactura) {
		this.listaFactura = listaFactura;
	}


	public TestFactura getFactura() {
		return factura;
	}


	public void setFactura(TestFactura factura) {
		this.factura = factura;
	}


	public int getIntCantidadProducto() {
		return intCantidadProducto;
	}


	public void setIntCantidadProducto(int intCantidadProducto) {
		this.intCantidadProducto = intCantidadProducto;
	}


	public List<TestProducto> getFiltroListaProductos() {
		return filtroListaProductos;
	}


	public void setFiltroListaProductos(List<TestProducto> filtroListaProductos) {
		this.filtroListaProductos = filtroListaProductos;
	}
	
	
	

}
