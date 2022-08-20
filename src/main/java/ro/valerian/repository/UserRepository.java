package ro.valerian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.valerian.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer> {

    public UserDtls findByEmail(String email);



}
