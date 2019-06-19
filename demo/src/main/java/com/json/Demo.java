package com.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.alibaba.fastjson.JSON;

public class Demo {
	public Demo() {
		String json = readFile("D:/json.txt");
		System.out.println(json);
		FacesResult result = JSON.parseObject(json, FacesResult.class);
		System.out.println(JSON.toJSONString(result));
	}

	public String readFile(String file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			StringBuffer sb = new StringBuffer();
			int len = 0;
			while (true) {
				byte[] b = new byte[1024];
				len = fis.read(b);
				if (len < 0) {
					break;
				}
				sb.append(new String(b, 0, len));
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Demo();
	}
}
