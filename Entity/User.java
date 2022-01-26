package com.hagere.ethiop.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Collection;


@Entity

@Getter
@Setter

@Data
@RequiredArgsConstructor

//person means the user from the public
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 20)
    @NotBlank(message="Name is required")
private String fullName;
    @Column( nullable = false)
    @NotBlank(message="Address is required")
    private String Address;
    @Column( nullable = false)
    @NotBlank(message="Date of Birth is required")
    private String DOB;
    @Column( nullable = false)
    @NotBlank(message="citizenship is required")
    private String citizenship;
    @Column( nullable = false)
    @NotBlank(message="gender is required")

    private String gender;
    @Column( nullable = false)
    @NotBlank(message="email is required")
    private String email;
    @Column( nullable = false)
    @NotBlank(message=" user name is required")
    private String username;
    @Column( nullable = false)
    @NotBlank(message=" Password is required")
    private String Password;
    @Column( nullable = false)
    private Integer mobileNumber;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.Password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }



}
