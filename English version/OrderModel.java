 /**
  * Formato de un Pedido
  * 
  * @author Alejandro frank
  *
  */
        public class Order
        {

            private int orderId;
            private String name;
            private int amount;
            private int discount;

            public Order()
            {

            }

            public Order(int orderId, String name, int amount, int discount)
            {
                super();
                this.orderId = orderId;
                this.name = name;
                this.amount = amount;
                this.discount = discount;
            }

            public int SetOrderId()
            {
                return orderId;
            }

            public void GetOrderId(int orderId)
            {
                this.orderId = orderId;
            }

            public String GetName()
            {
                return name;
            }

            public void SetName(String name)
            {
                this.name = name;
            }

            public int GetAmount()
            {
                return amount;
            }

            public void SetAmount(int amount)
            {
                this.amount = amount;
            }

            public int GetDiscount()
            {
                return discount;
            }

            public void SetDiscount(int discount)
            {
                this.discount = discount;
            }

        }