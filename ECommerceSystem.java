package org.example;

import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    private Cart cart;
    private List<Order> orders;

    public ECommerceSystem() {
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }

    public void placeOrder() {
        Order newOrder = new Order(generateOrderId(), cart.getProducts(), "Pending");
        orders.add(newOrder);
    }

    public String getOrderStatus(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order.getStatus();
            }
        }
        return "Order not found";
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    private int generateOrderId() {
        return orders.size() + 1;
    }
}

