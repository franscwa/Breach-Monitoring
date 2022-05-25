package projects.Personal.DataBreach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.Personal.DataBreach.exception.UserNotFoundException;
import projects.Personal.DataBreach.model.Credential;
import projects.Personal.DataBreach.repo.CredentialRepo;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class CredentialService {
    private final CredentialRepo credentialRepo;
    @Autowired
    public CredentialService(CredentialRepo credentialRepo) {
        this.credentialRepo = credentialRepo;
    }


    public Credential saveCredential(Credential credential) {
       return credentialRepo.save(credential);
        /* credential.setEmail(UUID.randomUUID().toString()); //this is where your user input goes
        return credentialRepo.save(credential);*/
    }

    public List<Credential> getAllCredentials() {
        return credentialRepo.findAll();
    }

    public Credential updateEmployee(Credential credential){

        return credentialRepo.save(credential);
    }

    public Credential findEmployeeById(Long id){
        return credentialRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id +" was not found!"));
    }

    public void deleteEmployee(Long id){
        credentialRepo.deleteEmployeeById(id);
    }
}
