package com.pk.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pk.user.VO.Department;
import com.pk.user.VO.ResponseTemplateVO;
import com.pk.user.entity.User;
import com.pk.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside save method of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside get method of UserService");
		ResponseTemplateVO vo=new ResponseTemplateVO();
		User user=userRepository.findById(userId).get();
		
		Department department=
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		vo.setDepartment(department);
		vo.setUser(user);
		return vo;
	}
	
}
