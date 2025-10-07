package hellojpa.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "item_id")
public class Album extends Item{
    private String artist;
}
