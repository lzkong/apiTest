package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.entity.User;
import com.service.UserService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EatServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private UserService UserService;

	@Test(groups = "eatOne")
	public void test1() {
		List<User> list = UserService.selectUsers();
		System.out.println(list.size() + "1");
	}

	@Test(groups = "eatTen")
	public void test2() {
		List<User> list = UserService.selectUsers();
		System.out.println(list.size() + "2");
	}
}
