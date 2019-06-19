package com.common.parameters;

public class ExcelCommon {

	public static String[] readHead = { "num", "url", "Step", "param", "hoperesult" };
	public static String readPath = "D:\\excel\\登录用例.xls";
	public static String writePath = "D:\\excel\\test.xls";
	public static String writeSheetName = "登录测试";
	// public static String[] headName = { "编码", "接口", "步骤", "参数", "预测结果", "实际结果" };
	// public static String[] writeHead = { "num", "url", "Step", "param",
	// "hoperesult", "trueresult" };

	public static enum head {
		num, url, Step, param, hoperesult, trueresult, message
	}

	public static enum headName {
		编码, 接口, 步骤, 参数, 预测结果, 实际结果, message
	}

}
