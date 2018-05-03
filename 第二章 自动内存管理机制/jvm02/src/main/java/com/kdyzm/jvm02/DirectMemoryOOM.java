package com.kdyzm.jvm02;

import java.lang.reflect.Field;

/**
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author kdyzm
 *
 */
public class DirectMemoryOOM {
	private static final int _1MB=1024*1024;
	
	public static void main(String[] args) throws IllegalArgumentException, ReflectiveOperationException {
		Field unsafeField = sun.misc.Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		sun.misc.Unsafe unsafe = (sun.misc.Unsafe)unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}
}
