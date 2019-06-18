package jp.co.sample.emp_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.domain.LoginAdministrator;
import jp.co.sample.emp_management.repository.AdministratorRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	AdministratorRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException{
		
		Administrator administer = null;
		try {
			administer = repository.findByMailAddress(mailAddress);
		}catch(Exception e) {
			throw new UsernameNotFoundException("管理者情報が取得できませんでした。");
		}
		
		if(administer == null) {
			throw new UsernameNotFoundException("登録されていない管理者情報です。");
		}
		
		return new LoginAdministrator(administer);
	}
	

}
