package com.techendear.ebill.user;

import java.util.List;

public interface UserService {

	public User getUserById(Long id);

	public List<User> getAllUsers();

	public User saveUser(User user);

	public User updateUser(User user, Long id) throws Exception;
	
}
