 /**
 * Methods are implented:
 * 
 * - order create - order edit - order find by id - order delete
 * 
 * @author Alejandro frank
 *
 */
        public class OrderManager
        {

            private BumexMemcached cache = BumexMemcached.getInstance();


           /// <summary>
           /// create and delete an order
           /// </summary>
           /// <param name="OrderId"></param>
           /// <param name="name"></param>
           /// <param name="amount"></param>
           /// <param name="discount"></param>
           /// <returns></returns>
           public order OrderCreate(int OrderId, String name, int amount, int discount)
            {
                try
                {
                    order order = new order(OrderId, name, amount, discount);
                    this.cache.set(String.valueOf(order.GetOrderId()), order);
                    insertOrUpdate(order); 
                    return order;
                }
                catch
                {
                    throw new Exception();
                }            
            }

            /// <summary>
            /// actualize the order and returns it
            /// </summary>
            /// <param name="order"></param>
            /// <returns></returns>
           public order OrderEdit(order order)
            {
                try
                {
                    order orderCache= (order)this.cache.get(String.valueOf(order.GetOrderId()));
                    if (orderCache == null)
                    {
                        orderCache = ordersDAO.select(order.GetOrderId());
                    }
                    ordersDAO.insertOrUpdate(orderCache);
                    return orderCache;
                }catch (Exception e)
                {
                    throw e;
                }              
            }

            /// <summary>
            /// search an order by id
            /// </summary>
            /// <param name="id"></param>
            /// <returns></returns>
           public order OrderFindById(Integer id)
            {
                try
                {
                    order orderEnCache = (order)this.cache.get(String.valueOf(id));
                    if (orderEnCache != null)
                    {
                        return orderEnCache;
                    }
                    return ordersDAO.select(id);
                }
                catch
                {
                    throw new Exception();
                }
            }

            /// <summary>
            /// delete an order of the database
            /// </summary>
            /// <param name="order"></param>
           public void OrderDelete(order order)
            {
                try
                {
                    if (this.cache.get(String.valueOf(order.GetOrderId())) != null)
                    {
                        this.cache.delete(String.valueOf(order.GetOrderId()));
                    }
                    ordersDAO.delete(order);
                }
                catch
                {
                    throw new Exception();
                }
            }

        }