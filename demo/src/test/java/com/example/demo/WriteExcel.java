package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.utils.ExcelJunitReport;

class WriteExcel {

	public static void main(String[] args) {
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("url", "BankName");
		dataMap.put("param", "Addr");
		dataMap.put("result", "Phone");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(dataMap);
		ExcelJunitReport rr = new ExcelJunitReport();
		ExcelJunitReport.writeExcel(list, 3, "D:\\excel\\test.xls", "test");

	}

}
