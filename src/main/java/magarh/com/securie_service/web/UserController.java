package magarh.com.securie_service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import magarh.com.securie_service.entities.AppUser;
import magarh.com.securie_service.service.AccountService;

@RestController
public class UserController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping( "/register")
	public AppUser  register(@RequestBody UserForm userForm) {
		  return accountService.saveUser(userForm.getUserName(), userForm.getPassword(), userForm.getConfirmed());
	}


}

@Data
class  UserForm{
	private String userName;
	private String password;
	private String confirmed;
}


