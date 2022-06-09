package projects.Personal.DataBreach.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projects.Personal.DataBreach.model.Credential;
import projects.Personal.DataBreach.service.CredentialService;


import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialResource {
    private final CredentialService credentialService;

    public CredentialResource(CredentialService credentialService){
        this.credentialService = credentialService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Credential>> getAllCredentials(){
        List<Credential> credentials = credentialService.getAllCredentials();
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Credential> getCredentialById(@PathVariable("id") Long id){
        Credential credential = credentialService.findCredentialById(id);
        return new ResponseEntity<>(credential, HttpStatus.OK);
    }



    @PostMapping("/addNew")
    public ResponseEntity<Credential> addCredentials(@RequestBody Credential credential){
        Credential newCredential = credentialService.saveCredential(credential);
        return new ResponseEntity<>(newCredential, HttpStatus.CREATED);
    }

    @PutMapping("/recheck")
    public ResponseEntity<Credential> updateCredential(@RequestBody Credential credential){
        Credential newCredential = credentialService.checkCredential(credential);

        return new ResponseEntity<>(newCredential, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteCredential(@PathVariable("id") Long id){
        credentialService.deleteCredentialbyId(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //@GetMapping("/find/{email}")
    //public ResponseEntity<Credential> getEmployeeByEmail(@PathVariable("email") String email){
    //    Credential credential = credentialService.findEmployeeByEmail(email);
    //    return new ResponseEntity<>(credential, HttpStatus.OK);
    //}

    //@GetMapping("/find/{passwordHash}")
    //public ResponseEntity<Credential> getEmployeeByPasswordHash(@PathVariable("passwordHash") String passwordHash){
    //    Credential credential = credentialService.findEmployeeByPasswordHash(passwordHash);
    //    return new ResponseEntity<>(credential, HttpStatus.OK);
    //}

    //@GetMapping("/find/{isCompromised}")
    //public ResponseEntity<Credential> getEmployeeByIsCompromised(@PathVariable("isCompromised") Boolean isCompromised){
    //    Credential credential = credentialService.findEmployeeByIsCompromised(isCompromised);
    //    return new ResponseEntity<>(credential, HttpStatus.OK);
    //}


    //@GetMapping("/find/{securityLevel}")
    //public ResponseEntity<Credential> getEmployeeBySecurityLevel(@PathVariable("securityLevel") Integer securityLevel){
    //    Credential credential = credentialService.findEmployeeBySecurityLevel(securityLevel);


}
