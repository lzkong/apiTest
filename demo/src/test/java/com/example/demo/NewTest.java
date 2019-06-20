package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() {
		RandomEmailGenerator obj = new RandomEmailGenerator();
		String email = obj.generate();

		Assert.assertNotNull(email);
		Assert.assertEquals(email, "testfeedback@yiibai.com");
	}

}
