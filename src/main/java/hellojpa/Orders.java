package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orders {
    @Id
    private Long orderId;

    private LocalDate orderDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Orders() {
    }

    public Orders(Long orderId, LocalDate orderDate, String status) {
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
}
