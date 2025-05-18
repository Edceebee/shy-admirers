package com.aksh.shyadmirer.configuration;

import com.aksh.shyadmirer.models.AppUser;
import com.aksh.shyadmirer.models.Role;
import com.aksh.shyadmirer.repository.AppUserRepository;
import com.aksh.shyadmirer.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    public CommandLineRunner createDefaultAdmin(
            AppUserRepository userRepo,
            RoleRepository roleRepo,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            String username = "admin";
            String password = "admin123";

            // 1) Create ROLE_ADMIN if missing
            Role adminRole = roleRepo.findByName("ROLE_ADMIN")
                    .orElseGet(() -> {
                        Role r = new Role();
                        r.setName("ROLE_ADMIN");
                        return roleRepo.save(r);
                    });

            // 2) Create the admin user if not present
            if (userRepo.findByUsername(username).isEmpty()) {
                AppUser admin = new AppUser();
                admin.setUsername(username);
                admin.setPassword(passwordEncoder.encode(password));
                admin.setRoles(Collections.singleton(adminRole));
                userRepo.save(admin);
                log.info("Created default admin user: {}", username);
            } else {
                log.info("Admin user already exists: {}", username);
            }
        };
    }
}
