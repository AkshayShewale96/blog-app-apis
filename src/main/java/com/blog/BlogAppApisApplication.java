package com.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.Entity.Role;
import com.blog.config.AppConstants;
import com.blog.repository.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	// We can use ModelMapper to convert one object to another 
	// (convert one class to another)
	// check in UserServiceImpl Class, at bottom.
	// directly implemented in CategoryServiceImple class.
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	// RUN METHOD
	@Override
	public void run(String... args) throws Exception {
		
		//to show Encrypted password only
		System.out.println(this.passwordEncoder.encode("maxpayne"));
		
		//create new Role(table)
		try {
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");
			
			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");
			
			List<Role> roles = List.of(role,role1);
			List<Role> result = this.roleRepo.saveAll(roles);
			result.forEach(r->{System.out.println(r.getName());});
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
