package magarh.com.securie_service.service;

import magarh.com.securie_service.entities.AppRole;
import magarh.com.securie_service.entities.AppUser;

public interface AccountService {
	
	public AppUser saveUser(String userName, String Pasword, String confirmed);
	
	public AppRole saveRole(AppRole appRole);
	
	public AppUser loaderUserByUserName(String userName);
	
	public void addRoleToUser(String userName,  String roleName);

}
