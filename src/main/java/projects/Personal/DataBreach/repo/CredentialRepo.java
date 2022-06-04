package projects.Personal.DataBreach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.Personal.DataBreach.model.Credential;

import java.util.Optional;

@Repository
public interface CredentialRepo extends JpaRepository<Credential, Long> {
    void deleteCredentialById(Long id);

     //add find credential by id
    Optional<Credential> findCredentialById(Long id);

    
}
