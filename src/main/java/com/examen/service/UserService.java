package com.examen.service;


import com.examen.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
	List<org.springframework.security.core.userdetails.User> getAllUsers();
	
	List<org.springframework.security.core.userdetails.User> getUsersByPagination(int pageNo, int pageSize);
	
	Integer getUsersCount();
	
	org.springframework.security.core.userdetails.User getUserById(Long id);
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);

	String uploadImage(MultipartFile image) throws IOException;
	
	String updateImage(String oldImageName, MultipartFile image) throws IOException;
	
	String encryptPassword(String password);
	
	
}
