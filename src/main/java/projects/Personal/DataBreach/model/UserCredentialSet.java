package projects.Personal.DataBreach.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialSet {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long set_id;

    @OneToMany
    List<Credentials> credentials = new ArrayList<>();



}
