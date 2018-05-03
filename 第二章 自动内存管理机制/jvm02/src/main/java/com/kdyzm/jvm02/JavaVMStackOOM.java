package com.kdyzm.jvm02;

/**
 * 
 * -Xss2M<br/>
 * <strong>1.不要轻易运行这段代码,windows操作系统会导致操作系统假死</strong><br/>
 * 2.有争议的demo：无法确定是堆溢出还是栈溢出？<br/>
 * 模拟java 栈out of memory的情况
 * @author kdyzm
 *
 */
public class JavaVMStackOOM {
	
	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread=new Thread(()->{
				dontStop();
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM x=new JavaVMStackOOM();
		x.stackLeakByThread();
	}
}
