package projects.Personal.DataBreach.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projects.Personal.DataBreach.model.Credentials;
import projects.Personal.DataBreach.service.CredentialService;


import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialResource {
    private final CredentialService credentialService;

    public CredentialResource(CredentialService credentialService){
        this.credentialService = credentialService;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/")
    public ResponseEntity<List<Credentials>> getAllCredentials(){
        List<Credentials> credentials = credentialService.getAllCredentials();
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Credentials> getCredentialById(@PathVariable("id") Long id){
        Credentials credential = credentialService.findCredentialById(id);
        return new ResponseEntity<>(credential, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/")
    public ResponseEntity<Credentials> addCredentials(@RequestBody Credentials credential){
        Credentials newCredential = credentialService.saveCredential(credential);
        return new ResponseEntity<>(newCredential, HttpStatus.CREATED);
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Credentials> updateCredential(@PathVariable("id") Long id , @RequestBody Credentials credential){
        String newEmail = null;
        Credentials newCredential = credentialService.findCredentialById(id);

        return new ResponseEntity<>(newCredential, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
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
