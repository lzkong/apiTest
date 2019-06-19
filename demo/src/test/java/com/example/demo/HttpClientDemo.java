package com.example.demo;

import java.io.IOException;

import org.junit.Test;

import com.utils.HttpClientUtils;
import com.utils.core.HttpEntityType;
import com.utils.core.HttpRequestConfig;
import com.utils.core.HttpRequestResult;

public class HttpClientDemo {

	@Test
	public void test() throws IOException {
		HttpRequestConfig config = HttpRequestConfig.create().url("http://gateway-test.lygou.cc/services/v1/gift/send")
				.httpEntityType(HttpEntityType.ENTITY_STRING)
				.json("{" + "\"r_user_id\":120," + "\"g_id\":126," + "\"regoin\":1," + "\"regoin_id\":23,"
						+ "\"g_num_id\":10," + "\"region_type\":1" + "}")
				.addHeader("Content-Type", "application/json").addHeader("Authorization", "debug:lygllabc1234")
				.addHeader("userId", "10000069");
		HttpRequestResult result = HttpClientUtils.post(config);
		System.out.println(result.getResponseText());
	}

}
