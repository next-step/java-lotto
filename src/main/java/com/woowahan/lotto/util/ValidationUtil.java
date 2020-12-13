package com.woowahan.lotto.util;

import java.util.List;

import com.woowahan.lotto.model.LottoNo;

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

	public static boolean hasNotNumber(List<String> numbers) {
		return numbers.stream()
			.anyMatch(ValidationUtil::isNotNumber);
	}

	public static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public static boolean hasWrongNumber(List<String> numbers) {
		if (numbers == null) {
			return true;
		}
		return numbers.stream()
			.anyMatch(ValidationUtil::isWrongNumber);
	}

	public static boolean isWrongNumber(String numberString) {
		return Integer.parseInt(numberString) > LottoNo.LOTTO_END_NUMBER
			|| Integer.parseInt(numberString) < LottoNo.LOTTO_START_NUMBER;
	}
}
