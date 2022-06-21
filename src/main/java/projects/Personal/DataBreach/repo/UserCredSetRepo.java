package projects.Personal.DataBreach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.Personal.DataBreach.model.UserCredentialSet;

@Repository
public interface UserCredSetRepo extends JpaRepository<UserCredentialSet, Long> {
}
