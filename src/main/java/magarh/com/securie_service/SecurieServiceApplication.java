package magarh.com.securie_service;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import magarh.com.securie_service.entities.AppRole;
import magarh.com.securie_service.service.AccountService;

@SpringBootApplication
public class SecurieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurieServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(AccountService accountService) {
		
		return args->{
			accountService.saveRole(new AppRole(null, "USER"));
			accountService.saveRole(new AppRole(null, "ADMIN"));
			
			Stream.of("Magarh", "Urielle", "Gael", "Dartane").forEach(user->{
				accountService.saveUser(user, "1234", "1234");
			});
			
			accountService.addRoleToUser("Magarh", "ADMIN");
		};
	}
	
	@Bean
	BCryptPasswordEncoder brcrypt() {
		
		return new BCryptPasswordEncoder();
	}

}
