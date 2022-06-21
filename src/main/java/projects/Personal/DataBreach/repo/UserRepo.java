package projects.Personal.DataBreach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.Personal.DataBreach.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

}
