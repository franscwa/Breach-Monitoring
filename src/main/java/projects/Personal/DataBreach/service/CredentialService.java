package projects.Personal.DataBreach.service;

import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import projects.Personal.DataBreach.exception.CredentialNotFound;
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
        //write code to call rest api with rest template
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.pwnedpasswords.com/range/" + credential.getPrefixedHash();
        String response = restTemplate.getForObject(url, String.class);
        if(response.contains(credential.getHashedPassword())){
            credential.setIsCompromised(true);
        //add email notification
        }


        return credentialRepo.save(credential);
    }

    public Credential findCredentialById(Long id){
        return credentialRepo.findCredentialById(id)
                .orElseThrow(() -> new CredentialNotFound("Credential by id " + id +" was not found!"));
    }

    public void deleteEmployee(Long id){
        try{
        credentialRepo.deleteEmployeeById(id);}
        catch (Exception e){
            System.out.println("Credential not found");
        }
    }
}
