package user.account.management.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "UserAccount")
@Table(name = "useraccount")
public class UserAccount implements Serializable {

    private static final long serialVersionUID = -2466159750114704927L;

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 1, max = 64)
    private String firstName;
    @Size(min = 1, max = 64)
    private String lastName;
    @Size(min = 3, max = 64)
    private String emailAddress;
    private Date dateOfBirth;

    public UserAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
