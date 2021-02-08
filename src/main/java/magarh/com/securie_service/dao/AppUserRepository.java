package magarh.com.securie_service.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import magarh.com.securie_service.entities.AppUser;

@RepositoryRestResource
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long>{

	public AppUser findByUserName(String userName);
}
