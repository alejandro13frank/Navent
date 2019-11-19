 /**
 * Se realizan los metodos:
 * 
 * - crear pedidos - modificar pedidos - buscar pedidos por id - borrar pedidos
 * 
 * @author Alejandro frank
 *
 */
        public class PedidosManager
        {

            private BumexMemcached cache = BumexMemcached.getInstance();

           /// <summary>
           /// Crea un pedido y lo retorna
           /// </summary>
           /// <param name="idPedido"></param>
           /// <param name="nombre"></param>
           /// <param name="monto"></param>
           /// <param name="descuento"></param>
           /// <returns></returns>
           public Pedido CrearPedido(int idPedido, String nombre, int monto, int descuento)
            {
                try
                {
                    Pedido pedido = new Pedido(idPedido, nombre, monto, descuento);
                    this.cache.set(String.valueOf(pedido.getIdPedido()), pedido);
                    insertOrUpdate(pedido); 
                    return pedido;
                }
                catch
                {
                    throw new Exception();
                }            
            }

            /// <summary>
            /// Actualiza el pedido y retorna el pedido actualizado
            /// </summary>
            /// <param name="pedido"></param>
            /// <returns></returns>
           public Pedido EditarPedido(Pedido pedido)
            {
                try
                {
                    Pedido pedidoEnCache = (Pedido)this.cache.get(String.valueOf(pedido.GetIdPedido()));
                    if (pedidoEnCache == null)
                    {
                        pedidoEnCache = PedidosDAO.select(pedido.GetIdPedido());
                    }
                    PedidosDAO.insertOrUpdate(pedidoEnCache);
                    return pedidoEnCache;
                }catch (Exception e)
                {
                    throw e;
                }              
            }

            /// <summary>
            /// busca mediante una ID el pedido
            /// </summary>
            /// <param name="id"></param>
            /// <returns></returns>
           public Pedido BuscarPorId(Integer id)
            {
                try
                {
                    Pedido pedidoEnCache = (Pedido)this.cache.get(String.valueOf(id));
                    if (pedidoEnCache != null)
                    {
                        return pedidoEnCache;
                    }
                    return PedidosDAO.select(id);
                }
                catch
                {
                    throw new Exception();
                }
            }

            /// <summary>
            /// borra un pedido de las base de datos
            /// </summary>
            /// <param name="pedido"></param>
           public void BorrarPedido(Pedido pedido)
            {
                try
                {
                    if (this.cache.get(String.valueOf(pedido.GetIdPedido())) != null)
                    {
                        this.cache.delete(String.valueOf(pedido.GetIdPedido()));
                    }
                    PedidosDAO.delete(pedido);
                }
                catch
                {
                    throw new Exception();
                }
            }

        }