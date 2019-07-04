package com.example.demo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Feature("前线突击测试")
public class Test01 {
	@Test(description = "侯征测试")
	@Story("测试发券")
	@Description("主要测试四种券发送")
	@Step("测试步骤....")
	public void failedTest() {
		System.out.println("1111");
	}
}
