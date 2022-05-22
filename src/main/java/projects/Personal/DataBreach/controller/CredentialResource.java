package projects.Personal.DataBreach.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projects.Personal.DataBreach.model.Credential;
import projects.Personal.DataBreach.service.CredentialService;


import java.util.List;

@RestController
@RequestMapping("/credential")
public class CredentialResource {
    private final CredentialService credentialService;

    public CredentialResource(CredentialService credentialService){
        this.credentialService = credentialService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Credential>> getAllCredentials(){
        List<Credential> credentials = credentialService.getAllCredentials();
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Credential> getEmployeeById(@PathVariable("id") Long id){
        Credential credential = credentialService.findEmployeeById(id);
        return new ResponseEntity<>(credential, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Credential> addEmployee(@RequestBody Credential credential){
        Credential newCredential = credentialService.saveCredential(credential);
        return new ResponseEntity<>(newCredential, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Credential> updateCredential(@RequestBody Credential credential){
        Credential newCredential = credentialService.updateEmployee(credential);

        return new ResponseEntity<>(newCredential, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        credentialService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
