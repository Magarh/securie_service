package magarh.com.securie_service.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import magarh.com.securie_service.entities.AppRole;

@RepositoryRestResource
public interface AppRoleRepository extends PagingAndSortingRepository<AppRole, Long>{
	
	public AppRole findByRoleName(String roleName);

}
