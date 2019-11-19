/**
 * Formato de un Pedido
 * 
 * @author Alejandro frank
 *
 */
public class Pedido {

	private int idPedido;
	private String nombre;
	private int monto;
	private int descuento;

	public Pedido() {

	}

	public Pedido(int idPedido, String nombre, int monto, int descuento) {
		super();
		this.idPedido = idPedido;
		this.nombre = nombre;
		this.monto = monto;
		this.descuento = descuento;
	}

	public int GetIdPedido() {
		return idPedido;
	}

	public void GetIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String GetNombre() {
		return nombre;
	}

	public void GetNombre(String nombre) {
		this.nombre = nombre;
	}

	public int GetMonto() {
		return monto;
	}

	public void GetMonto(int monto) {
		this.monto = monto;
	}

	public int GetDescuento() {
		return descuento;
	}

	public void GetDescuento(int descuento) {
		this.descuento = descuento;
	}

}