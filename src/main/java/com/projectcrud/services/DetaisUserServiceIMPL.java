package com.projectcrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projectcrud.dataJWT.DataDetails;
import com.projectcrud.entities.User;
import com.projectcrud.repositories.UserRepository;

@Component
public class DetaisUserServiceIMPL implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByEmail(username);

		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");

		}
		return new DataDetails(user);
	}

}
