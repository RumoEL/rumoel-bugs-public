package com.github.rumoel.header;

import com.github.rumoel.listeners.ClipboardListener;
import com.github.rumoel.listeners.CommandListener;

public class HeaderPasswdPam {

	public static CommandListener commandListener = new CommandListener();
	public static ClipboardListener clipboardListener = new ClipboardListener();

	public static StringBuilder poc = new StringBuilder();
	public static String host = "127.0.0.1";
	public static int port = 9000;

	public static boolean useSudo = true;

	public static String realClip;

}
