package com.kdyzm.jvm02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M<br/>
 * 上述两个参数限制了方法区大小，从而限制了常量池大小，只在1.6中有效<br/>
 * 在1.6版本中会出现如下异常：
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space at
 * java.lang.String.intern(Native Method) at
 * com.kdyzm.jvm02.RuntimeConstantOOM.main(RuntimeConstantOOM.java:19)
 * </p>
 * 在1.7及以上版本中则不会出现该异常
 * 
 * @author kdyzm
 *
 */
public class RuntimeConstantOOM {
	public static void main(String[] args) {
		// 使用List保持着常量池的引用，必变Full GC回收常量池的行为
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
//		test();
	}

	public static void test() {
		// 1.6返回false，1.7+返回true
		String str = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str == str.intern());

		// 1.6返回false，1.7+返回false
		String str1 = new StringBuilder("ja").append("va").toString();
		System.out.println(str1 == str1.intern());
	}
}
