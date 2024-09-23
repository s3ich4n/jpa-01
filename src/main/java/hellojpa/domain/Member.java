package hellojpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    private String name;

    private String city;

    private String street;

    private int zipCode;

    // 상대 엔티티의 이름을 참조
    //      가급적 단방향을 생각하기
    //      필요할 때 양방향을 넣는게 좋음
    //          이 방향도 썩 좋은 설계는 아님
    //          차라리 orders에서 member_id를 가지고 그걸로 처리하는 건 잘 없다
    //          설계할 때 이 연관관계를 잘 끊어낼 필요가 있다. 본업에서도 마찬가지.
    //      멤버가 orders를 알 필요가 있나? 를 생각해보기.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrders(Order... orders) {
        List<Order> newOrders = Stream.of(orders).toList();
        this.orders.addAll(newOrders);
        newOrders.forEach(order -> order.setMember(this));
    }
}
