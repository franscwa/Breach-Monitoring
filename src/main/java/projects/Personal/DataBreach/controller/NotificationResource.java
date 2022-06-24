package projects.Personal.DataBreach.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projects.Personal.DataBreach.model.Credentials;
import projects.Personal.DataBreach.service.CredentialService;
import projects.Personal.DataBreach.service.NotificationService;

@Controller
@RequestMapping("/notify")
public class NotificationResource {
    private final NotificationService notificationService;

    private final CredentialService credentialService;

    public NotificationResource(NotificationService notificationService, CredentialService credentialService) {
        this.notificationService = notificationService;
        this.credentialService = credentialService;
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/notify/{id}")
    public ResponseEntity<Credentials> NotifyById(@PathVariable("id") Long id){
        Credentials credential = credentialService.findCredentialById(id);

        return new ResponseEntity<>(credential, HttpStatus.OK);
    }

}
