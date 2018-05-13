package com.kdyzm.jvm04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BTraceTest {
	public static void main(String[] args) throws IOException {
		BTraceTest test = new BTraceTest();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			br.readLine();
			int a = new Random().nextInt(100);
			int b = new Random().nextInt(100);
			System.out.println(test.add(a, b));
		}

	}

	public int add(int a, int b) {
		return a + b;
	}
}
