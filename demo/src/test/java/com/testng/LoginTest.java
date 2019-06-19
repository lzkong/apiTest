package com.testng;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.common.ResponseContext;
import com.common.Status;
import com.common.parameters.ExcelCommon;
import com.utils.ExcelJunitReport;
import com.utils.HttpClientUtils;
import com.utils.ReadExcelUtil;
import com.utils.core.HttpRequestConfig;
import com.utils.core.HttpRequestResult;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest extends AbstractTestNGSpringContextTests {

	@Test
	public void login() throws IOException {

		File file = new File(ExcelCommon.readPath);
		try {
			// 获取excel list
			List<Map<String, String>> list = ReadExcelUtil.readExcel(file, ExcelCommon.readHead);

			if (list != null) {

				for (int i = 0; i < list.size(); i++) {

					Map<String, String> row = list.get(i);

					String url = row.get(ExcelCommon.head.url.toString());
					String[] params = row.get(ExcelCommon.head.param.toString()).split(",");

					HttpRequestConfig config = HttpRequestConfig.create(); // 设置url
					config.url(url);
					if (params != null && params.length > 0) {

						for (int j = 0; j < params.length; j++) {
							String[] param = params[j].split(":");
							config.addParam(param[0], param[1]);
						}

					}

					// 发送请求
					HttpRequestResult result = HttpClientUtils.post(config);
					System.out.println(result);
					// 断言处理 默认结果
					row.put(ExcelCommon.head.trueresult.toString(), Status.falseStatus);
					assertThat(result).isNotNull();

					assertThat(result.getCode()).isNotNull();
					assertThat(result.getCode()).isEqualTo(Status.responseCode);
					String response = result.getResponseText();
					String code = JSON.parseObject(response).get(Status.code).toString();
					row.put(ExcelCommon.head.message.toString(),
							JSON.parseObject(response).get(Status.message).toString());
					if (code.equals(ResponseContext.getCode())) {
						row.put(ExcelCommon.head.trueresult.toString(), Status.SuccessStatus);

					}

				}
			}

			ExcelJunitReport.writeExcel(list, ExcelCommon.head.values().length, ExcelCommon.writePath,
					ExcelCommon.writeSheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
