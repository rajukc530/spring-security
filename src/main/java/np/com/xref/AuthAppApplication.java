package np.com.xref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import np.com.xref.model.Role;
import np.com.xref.model.RoleName;
import np.com.xref.repository.RoleRepository;

@SpringBootApplication
public class AuthAppApplication implements CommandLineRunner {

	@Autowired
	RoleRepository role;

	public static void main(String[] args) {
		SpringApplication.run(AuthAppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
			Role adminRole = new Role();
			adminRole.setName(RoleName.ROLE_ADMIN);
			role.save(adminRole);
			
			Role userRole = new Role();
			userRole.setName(RoleName.ROLE_USER);
			role.save(userRole);

	}
		
}
