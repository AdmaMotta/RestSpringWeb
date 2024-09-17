package dio.me.RestSpringWeb;

import java.util.Arrays;

import jakarta.annotation.PostConstruct;

import dio.me.RestSpringWeb.auth.entity.Role;
import dio.me.RestSpringWeb.auth.entity.User;
import dio.me.RestSpringWeb.auth.service.RoleService;
import dio.me.RestSpringWeb.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class Initializer {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void criaUsuariosEPermissoes() {
        Role roleAdmin = new Role();

        roleAdmin.setName("USER");

        roleService.save(roleAdmin);

        User user = new User();
        user.setAtivo(true);
        user.setEmail("teste@teste.com");
        user.setNome("Kaique Arantes");
        user.setSenha(new BCryptPasswordEncoder().encode("123456"));
        user.setUsername("karantes");
        user.setRoles(Arrays.asList(roleAdmin));

        userService.save(user);

    }
}
