package hellojpa;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class OrderItem {
    @Id
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "orders")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "orderItems")
    private Item items;

    private BigDecimal orderPrice;

    private Long count;
}
