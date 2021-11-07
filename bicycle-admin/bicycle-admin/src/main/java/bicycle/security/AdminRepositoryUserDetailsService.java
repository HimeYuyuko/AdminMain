package bicycle.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bicycle.repository.AdminRepository;

// username에 해당하는 사용자 검색 서비스
@Service
public class AdminRepositoryUserDetailsService implements UserDetailsService {
	private AdminRepository adminRepo;
	
	@Autowired
	public AdminRepositoryUserDetailsService(AdminRepository adminRepo) {
		this.adminRepo = adminRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		var admin = adminRepo.findById(username);
		
		if (admin.isPresent()) {
			return admin.get();
		}
		
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}

}
