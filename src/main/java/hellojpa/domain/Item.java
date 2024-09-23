package hellojpa.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id @GeneratedValue
    @Column(name="item_id")
    private Long itemId;

    private String name;

    private BigDecimal price;

    private Long stockQuantity;

    // 상대 엔티티의 이름을 참조
    //      가급적 단방향을 생각하기
    //      필요할 때 양방향을 넣는게 좋음
    //      상품 입장에서 어떤 주문을 쫓아가야하는가? 에 대한 여부는
    //      비즈니스의 중요성을 보고 판단하기.
    @OneToMany(mappedBy = "items")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public Item() {
    }

    public Item(Long itemId, String name, BigDecimal price, Long stockQuantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
