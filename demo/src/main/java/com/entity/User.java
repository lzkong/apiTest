package com.entity;

public class User {
	private String username;
	private String password;
	private String patternLock;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPatternLock() {
		return patternLock;
	}

	public void setPatternLock(String patternLock) {
		this.patternLock = patternLock;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", patternLock=" + patternLock + "]";
	}

}
