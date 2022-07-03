package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "info")

public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String qyteti;
    private String shteti;

}
