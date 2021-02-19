package com.techendear.ebill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserById(Long id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(User user) throws Exception {
		User existingUser = this.userRepository.findById(user.getUserId()).get();
		if (existingUser.getUserId() != user.getUserId()) {
			throw new Exception("User doesn't exists with id: " + existingUser.getUserId());
		}
		return this.userRepository.save(user);
	}

}
