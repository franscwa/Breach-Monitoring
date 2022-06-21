package projects.Personal.DataBreach.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Data
@AllArgsConstructor
public class Credentials implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private int securityLevel;
    private boolean isCompromised;
    private String password;
    private String hashedPassword;


    private String hashPrefix;

    public Credentials() {

    }

    //TO DO: Add Salting

    //Hash function for Password
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


    public void setHashPrefix(String hashToPrefix) {
        hashPrefix = hashToPrefix.substring(0, 5);
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = sha1(hashedPassword);
    }

    public Credentials(String email, String password, int securityLevel) {
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
