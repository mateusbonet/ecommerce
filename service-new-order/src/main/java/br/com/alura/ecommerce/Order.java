package br.com.alura.ecommerce;

import java.math.BigDecimal;

public class Order {

    private final BigDecimal amount;

    private final String email;

    public Order(String orderId, BigDecimal value, String email) {
        this.amount = value;
        this.email = email;
    }

}
