package com.kdyzm.jvm0903;

/**
 * Bytes数组处理工具
 * 
 * @author kdyzm
 *
 */
public class ByteUtils {
	public static int byte2Int(byte[] b, int start, int len) {
		int sum = 0;
		int end = start + len;
		for (int i = start; i < end; i++) {
			int n = ((int) b[i]) & 0XFF;
			n <<= (--len) * 8;
			sum += n;
		}
		return sum;
	}

	public static byte[] int2Bytes(int value, int len) {
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			b[len - i - 1] = (byte) ((value >> 8 * i) & 0Xff);
		}
		return b;
	}

	public static String bytes2String(byte[] b, int start, int len) {
		return new String(b, start, len);
	}

	public static byte[] string2Bytes(String str) {
		return str.getBytes();
	}

	public static byte[] bytesReplace(byte[] originBytes, int offset, int len, byte[] replaceBytes) {
		byte[] newBytes = new byte[originBytes.length + (replaceBytes.length - len)];
		System.arraycopy(originBytes, 0, newBytes, 0, offset);
		System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
		System.arraycopy(originBytes, offset + len, newBytes, offset + replaceBytes.length,
				originBytes.length - offset - len);
		return newBytes;
	}
}
