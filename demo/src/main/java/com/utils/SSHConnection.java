package com.utils;

import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHConnection {
//https://blog.csdn.net/qq_41933709/article/details/88358040

	private final static int LOCAl_PORT = 3307;
	private final static int REMOTE_PORT = 3306;
	private final static int SSH_REMOTE_PORT = 8080;
	private final static String SSH_USER = "sshuser";
	private final static String SSH_PASSWORD = "sshpassword";
	private final static String SSH_REMOTE_SERVER = "sshurl";
	private final static String MYSQL_REMOTE_SERVER = "数据库地址";

	private Session sesion; // represents each ssh session

	public void closeSSH() {
		sesion.disconnect();
	}

	public SSHConnection() throws Throwable {

		JSch jsch = null;
		jsch = new JSch();

		sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
		sesion.setPassword(SSH_PASSWORD);

		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		sesion.setConfig(config);

		sesion.connect(); // ssh connection established!

		// by security policy, you must connect through a fowarded port
		sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);

	}
}
