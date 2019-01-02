package com.admin.action;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction
{
	private final static Logger log = LoggerFactory.getLogger(UserAction.class);
	
	@RequestMapping("/user/me")
	public Principal user(Principal principal)
	{
		log.info(principal+"");
		return principal;
	}
}
