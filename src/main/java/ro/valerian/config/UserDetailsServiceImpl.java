package ro.valerian.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ro.valerian.entity.UserDtls;
import ro.valerian.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public UserDetailsServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDtls user = userRepo.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User Not Exist");
        } else {
            CustomUserDtls customUserDtls = new CustomUserDtls(user);
            return customUserDtls;
        }
    }


}
