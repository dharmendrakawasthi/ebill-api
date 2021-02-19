package com.techendear.ebill.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().header("api-path", "/api/v1/user/" + id).body(this.userService.getUserById(id));
	}

	@PostMapping("")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return ResponseEntity.ok().header("api-path", "/api/v1/user/").body(this.userService.saveUser(user));
	}

	@PutMapping("")
	public ResponseEntity<?> updateUser(@RequestBody User user)  {
		try {
			return ResponseEntity.ok().header("api-path", "/api/v1/user/" + user.getUserId()).body(this.userService.updateUser(user));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("ERROR: "+e.getMessage());
		}
	}
}
