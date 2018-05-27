package com.kdyzm.jvm0903;

import java.lang.reflect.Method;

/**
 * Java Class执行工具
 * 
 * @author kdyzm
 *
 */
public class JavaClassExecuter {

	public static String execute(byte[] classByte) throws Exception, SecurityException {
		HackSystem.clearBuffer();
		ClassModifier cm = new ClassModifier(classByte);
		byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "com/kdyzm/jvm0903/HackSystem");
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(modiBytes);
		Method method = clazz.getMethod("main", new Class[] { String[].class });
		method.invoke(null, new String[] { null });
		return HackSystem.getBufferString();
	}
}
