package com.kdyzm.jvm0903;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:\\GitRepositories\\a_deep_understanding_of_the_java_virtual_machine\\第09章 类加载及执行子系统的案例与实战\\jvm09\\target\\classes\\com\\kdyzm\\jvm0903\\Test.class");
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();

		System.out.println(JavaClassExecuter.execute(b));
	}
}
