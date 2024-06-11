public class Order {
    private Cart cart;
    private PaymentMethod paymentMethod;

    public Order(Cart cart, PaymentMethod paymentMethod){
        this.cart = cart;
        this.paymentMethod = paymentMethod;
    }

    public Cart getCart(){
        return cart;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod; 
    }
}
