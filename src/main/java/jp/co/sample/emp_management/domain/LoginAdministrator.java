package jp.co.sample.emp_management.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class LoginAdministrator extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Administrator administrator;
	
	public LoginAdministrator(Administrator administrator) {
		super(administrator.getMailAddress(),administrator.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.administrator = administrator;
	}
	
	public Administrator getAdministrator() {
		return administrator;
	}

}
