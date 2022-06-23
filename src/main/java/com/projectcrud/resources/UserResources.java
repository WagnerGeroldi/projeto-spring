package com.projectcrud.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectcrud.entities.User;
import com.projectcrud.exceptionResponseDetails.ErrorUserEmpty;
import com.projectcrud.repositories.UserRepository;
import com.projectcrud.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> list = userService.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {

		Optional<User> user = userService.findById(id);

		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {

		if (verifyEmailExists(user) == true) {
			throw new ErrorUserEmpty("Usuário já cadatrado");
		}

		user.setPassword(encoder.encode(user.getPassword()));
		user = userService.insert(user);
		return ResponseEntity.status(201).build();

	}

	@PostMapping("/validate")
	public ResponseEntity<Boolean> passwordValidate(@RequestBody User user) {

		if (verifyEmailExists(user) == false) {
			throw new ErrorUserEmpty("Usuário não cadastrado");
		}

		Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
		User userBD = userEmail.get();
		boolean validation = encoder.matches(user.getPassword(), userBD.getPassword());

		HttpStatus status = (validation) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

		return ResponseEntity.status(status).body(validation);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		userService.delete(id);

		return ResponseEntity.noContent().build();
	}

	public Boolean verifyEmailExists(User user) {

		Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
		Boolean value = null;
		if (userEmail.isEmpty()) {
			value = false;
		} else {
			value = true;
		}

		return value;
	}

}
