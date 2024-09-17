package dio.me.RestSpringWeb.auth.repository;

import dio.me.RestSpringWeb.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
