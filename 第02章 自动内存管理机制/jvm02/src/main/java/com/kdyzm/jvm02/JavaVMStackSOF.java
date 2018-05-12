package com.kdyzm.jvm02;

/**
 * -Xss128K
 * 模拟java虚拟机栈stack over flow的情况
 * @author kdyzm
 *
 */
public class JavaVMStackSOF {
	int stackLength = 1;

	public static void main(String[] args) {
		JavaVMStackSOF jvmsof = new JavaVMStackSOF();
		try {
			jvmsof.stackLength();
		} catch (Throwable e) {//使用Throwable接口捕获而不使用Exception捕获
			System.out.println("stackLength:" + jvmsof.stackLength);
//			e.printStackTrace();
			throw e;
		}
	}

	public void stackLength() {
		stackLength++;
		stackLength();
	}
}
