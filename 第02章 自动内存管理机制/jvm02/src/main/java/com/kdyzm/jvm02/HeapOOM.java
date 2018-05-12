package com.kdyzm.jvm02;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError <br/>
 * 模拟堆溢出的情况
 * 
 * @author kdyzm
 *
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
