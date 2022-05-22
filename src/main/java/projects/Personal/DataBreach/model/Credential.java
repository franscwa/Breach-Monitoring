package projects.Personal.DataBreach.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Credential implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)

    private Long id;
    private String email;
    private int securityLevel;
    private boolean isCompromised;
    private String password;


    public Credential() {

    }

    public Long getId() {
        return id;
    }

    public Credential(String email, String password, int securityLevel, boolean isCompromised) {
        this.email = email;
        this.password = password;
        this.securityLevel = securityLevel;
        this.isCompromised = isCompromised;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public boolean getIsCompromised(){return isCompromised;}

    public void setIsCompromised(boolean isCompromised){this.isCompromised = isCompromised;}

}
