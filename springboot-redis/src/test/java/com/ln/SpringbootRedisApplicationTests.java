package com.ln;

import com.ln.entity.User;
import com.ln.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRedisApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		User u = userService.getUserById(1);

		userService.updateUserById(1);
		User u1 = userService.getUserById(1);
		System.out.println(u);
		System.out.println(u1);
	}

}
