package com.example.demo;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.utils.ReadExcelUtil;

public class testexcel {

	@Test
	public void test() {

		String[] head = { "num", "url", "step", "param", "result" };
		File file = new File("D:\\excel\\登录用例.xls");

		try {

			List<Map<String, String>> list = ReadExcelUtil.readExcel(file, head);

			if (list != null) {

				for (int i = 0; i < list.size(); i++) {

					Map<String, String> row = list.get(i);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
