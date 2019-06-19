package com.json;

import java.util.ArrayList;
import java.util.List;

public class FacesResult {

	private static final String TAG = "JavaTest.Face";
	// List对应数组
	List<Face> face = new ArrayList<Face>();
	String session_id;
	int img_height;
	int img_width;
	String img_id;
	String url;
	String response_code;
	/*
	 * 所有的成员变量都要实现set get
	 */

	public List<Face> getFace() {
		return face;
	}

	public void setFace(List<Face> face) {
		this.face = face;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public int getImg_height() {
		return img_height;
	}

	public void setImg_height(int img_height) {
		this.img_height = img_height;
	}

	public int getImg_width() {
		return img_width;
	}

	public void setImg_width(int img_width) {
		this.img_width = img_width;
	}

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponse_code() {
		return response_code;
	}

	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
}
