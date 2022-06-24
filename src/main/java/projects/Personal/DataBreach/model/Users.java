package projects.Personal.DataBreach.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long user_id;
    private String email;
    private String name;



    @OneToMany(targetEntity = UserCredentialSet.class, cascade = CascadeType.ALL)
            @JoinColumn(name="set_key", referencedColumnName = "user_id")
    List<UserCredentialSet> userCredentialSets =  new ArrayList<>();
    //make a UUID as a primary key
}
