package ro.valerian.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserDtls  {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String name;
    private String email;
    private String password;
    private String about;
    private String role;

    public UserDtls() {
    }
}
