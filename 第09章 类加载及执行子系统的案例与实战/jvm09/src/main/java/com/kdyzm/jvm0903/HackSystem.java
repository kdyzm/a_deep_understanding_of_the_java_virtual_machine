package com.kdyzm.jvm0903;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * <p>
 * TODO 为JavaClass劫持java.lang.System提供支持<br/>
 * 除了out和err之外，其余的都直接转发给Sytem处理
 * 
 * @author kdyzm
 *
 *         </p>
 */
public class HackSystem {

	public static final InputStream is = System.in;
	private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	public static final PrintStream out = new PrintStream(buffer);
	public final static PrintStream err = out;

	public static String getBufferString() {
		return buffer.toString();
	}
	
	public static void clearBuffer(){
		buffer.reset();
	}
	
	public static void setSecurityManager(final SecurityManager s){
		System.setSecurityManager(s);
	}
	public static SecurityManager getSecurityManager(){
		return System.getSecurityManager();
	}
	
	//TODO 下面所有方法都与java.lang.System的方法一样
	
	
}
