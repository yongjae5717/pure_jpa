package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK") // default: class명
public class Book extends Item{
    private String author;

    private String isbn;

}
