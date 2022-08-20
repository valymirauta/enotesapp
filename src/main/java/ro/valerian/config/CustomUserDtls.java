package ro.valerian.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.valerian.entity.UserDtls;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDtls implements UserDetails {

    private UserDtls userDtls;

    public CustomUserDtls(UserDtls userDtls) {
        super();
        this.userDtls = userDtls;
    }

    public CustomUserDtls() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(userDtls.getRole());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return userDtls.getPassword();
    }

    @Override
    public String getUsername() {
        return userDtls.getEmail();
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
