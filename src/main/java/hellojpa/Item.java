package hellojpa;

import javax.persistence.*;

@Entity
// Join 전략
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private Long id;

    private String name;

    private int price;


}
