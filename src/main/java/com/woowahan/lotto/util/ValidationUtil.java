package com.woowahan.lotto.util;

public class ValidationUtil {

	public static boolean isZeroOrNegative(String value) {
		int num = Integer.parseInt(value);
		return num <= 0;
	}

	public static boolean isNotNumber(String value) {
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public static boolean existRemainder(int value, int divider) {
		return (value % divider) != 0;
	}
}
