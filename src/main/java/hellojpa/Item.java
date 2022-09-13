package hellojpa;

import javax.persistence.*;

@Entity
// Join 전략, 싱글 테이블 전
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// INSERT DTYPE
@DiscriminatorColumn
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
