package com.github.rumoel;

import com.github.rumoel.header.HeaderPasswdPam;
import com.github.rumoel.utils.PasswdPamUtils;

public class App {

	public static void main(String[] args) {
		PasswdPamUtils.createPoc();
		startListeners();
	}

	private static void startListeners() {
		HeaderPasswdPam.commandListener.start();
		HeaderPasswdPam.clipboardListener.start();
	}
}