package projects.Personal.DataBreach.service;

import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.Personal.DataBreach.exception.CredentialNotFound;
import projects.Personal.DataBreach.exception.UserNotFoundException;
import projects.Personal.DataBreach.model.Credential;
import projects.Personal.DataBreach.repo.CredentialRepo;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class CredentialService<WebClient> {
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

    public Credential checkCredential(Credential credential){
        {
            WebClient webClient = WebClient.create("https://haveibeenpwned.com/api/v2/breachedaccount/" + passwordHash);
            webClient.get()
                    .retrieve()
                    .bodyToMono(String.class)
                    .subscribe(response -> {
                        if (response.equalsIgnoreCase(pass)) {
                            credential.setIsCompromised(true);
                        } else {
                            credential.setIsCompromised(false);
                        }
                    });

        }
        return credentialRepo.save(credential);
    }

    public Credential findEmployeeById(Long id){
        return credentialRepo.findEmployeeById(id)
                .orElseThrow(() -> new CredentialNotFound("Credential by id " + id +" was not found!"));
    }

    public void deleteEmployee(Long id){
        credentialRepo.deleteEmployeeById(id);
    }
}
