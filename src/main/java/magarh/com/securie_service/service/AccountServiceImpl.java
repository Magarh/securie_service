package magarh.com.securie_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import magarh.com.securie_service.dao.AppRoleRepository;
import magarh.com.securie_service.dao.AppUserRepository;
import magarh.com.securie_service.entities.AppRole;
import magarh.com.securie_service.entities.AppUser;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcript;
	
	@Override
	public AppUser saveUser(String userName, String password, String confirmed) {
	
		 AppUser user = appUserRepository.findByUserName(userName);
		 if(user!=null) throw new RuntimeException("L'utilisateur existe déjà.");
		 if(!password.equals(confirmed)) throw new RuntimeException("Confirmez le mot de passe");
		 AppUser appUser = new AppUser();
		 appUser.setUserName(userName);
		 appUser.setActive(true);
		 appUser.setPassword(bcript.encode(password));
		 appUserRepository.save(appUser);
		 addRoleToUser(userName, "USER");
		return appUser;
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loaderUserByUserName(String userName) {
		
		return appUserRepository.findByUserName(userName);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		
		AppUser user = appUserRepository.findByUserName(userName);
		AppRole role = appRoleRepository.findByRoleName(roleName);
		user.getRoles().add(role);
	}

}
