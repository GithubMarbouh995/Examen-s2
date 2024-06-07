package com.examen.service;


import com.examen.model.User;
import com.examen.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	private String UPLOAD_DIR = System.getProperty("user.dir") 
								+ "/src/main/resources/static/uploads/";
	
	Path rootLocation = Paths.get(UPLOAD_DIR);
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<org.springframework.security.core.userdetails.User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Integer getUsersCount() {
		return (int) userRepository.count();
	}


	@Override
	public List<org.springframework.security.core.userdetails.User> getUsersByPagination(int pageNo, int pageSize) {
		
		PageRequest pageReq = PageRequest.of(pageNo-1, pageSize);
		Page<org.springframework.security.core.userdetails.User> page = userRepository.findAll(pageReq);
		
		return page.getContent();
	}

	@Override
	public org.springframework.security.core.userdetails.User getUserById(Long id) {
		Optional<org.springframework.security.core.userdetails.User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {

			throw new RuntimeException("User not found for id: " + id);
		}
	}

	@Override
	public User saveUser(User user) {
		return null;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}


	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public String uploadImage(MultipartFile image) throws IOException {
		
		if(image != null && !image.isEmpty()) {
						
			String originalFilename = image.getOriginalFilename();
			String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
			String uniqueName = UUID.randomUUID().toString() + extension;
			
			Path path = Paths.get(UPLOAD_DIR + uniqueName);
			Files.write(path, image.getBytes());
			
			System.out.println("UPLOAD PATH : " + UPLOAD_DIR + uniqueName);
			return uniqueName;
		}		
		return null;
	}
	
	@Override
	public String encryptPassword(String password) {		
		 int strength = 10; 
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		 String encodedPassword = bCryptPasswordEncoder.encode(password);
		
		return encodedPassword;
	}
	
	@Override
	public String updateImage(String oldImageName, MultipartFile image) throws IOException {
		
		if(image != null && !image.isEmpty()) {
			File oldImage = new File(UPLOAD_DIR + oldImageName);
			if(oldImage.exists() && oldImage.isFile()) {
				oldImage.delete();
			}
		}
		return uploadImage(image);
	}


	

	
	

}
