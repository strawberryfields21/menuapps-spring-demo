package MenuApps.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "master_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="description")
    private String description;
    @Column(name ="price")
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;

}
