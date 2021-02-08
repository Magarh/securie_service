package magarh.com.securie_service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import magarh.com.securie_service.entities.AppUser;
import magarh.com.securie_service.service.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		AppUser appUser = accountService.loaderUserByUserName(userName);
		if(appUser==null) throw new UsernameNotFoundException("Utilisateur non trouvé");
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		appUser.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(appUser.getUserName(), appUser.getPassword(), authorities);
	}

}
