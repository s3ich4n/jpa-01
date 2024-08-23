package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
public class Member {
    @Id
    private Long memberId;

    private String name;

    private String city;

    private String street;

    private int zipCode;

    // 상대 엔티티의 이름을 참조
    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<Orders>();

    public Member(Long memberId, String name, String city, String street, int zipCode) {
        this.memberId = memberId;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Member() {

    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void addOrders(Orders... orders) {
        List<Orders> newOrders = Stream.of(orders).toList();
        this.orders.addAll(newOrders);
        newOrders.forEach(order -> order.setMember(this));
    }
}
