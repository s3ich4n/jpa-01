package hellojpa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    private LocalDate orderDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 이건 가치있을 것으로 판단
    //      "주문"을 중심으로 실제 "주문물품"을 가질 필요가 있으면
    //      필요하다는 생각때문. 이 "왜?"를 도출하는 과정을 잘 따라가라
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public Order() {
    }

    public Order(Long orderId, LocalDate orderDate, String status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }
}
