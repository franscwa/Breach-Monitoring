package projects.Personal.DataBreach.model;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String hashedPassword;

    private String prefixedHash;

    public Credential() {

    }

    public String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    public boolean isCompromised() {
        return isCompromised;
    }

    public void setCompromised(boolean compromised) {
        isCompromised = compromised;
    }

    public String getPrefixedHash() {
        return prefixedHash;
    }

    public void setPrefixedHash(String hashToPrefix) {
        this.prefixedHash = hashToPrefix.substring(0, 5);
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = sha1(hashedPassword);
    }

    public Long getId() {
        return id;
    }

    public Credential(String email, String password, int securityLevel) {
        this.email = email;
        this.password = password;
        this.securityLevel = securityLevel;

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
