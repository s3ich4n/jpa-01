package hellojpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    private Long itemId;

    private String name;

    private BigDecimal price;

    private Long stockQuantity;

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
