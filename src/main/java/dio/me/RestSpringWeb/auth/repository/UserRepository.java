package dio.me.RestSpringWeb.auth.repository;

import dio.me.RestSpringWeb.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
