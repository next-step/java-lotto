package lotto.utils;

import lotto.domain.Message;

public class ValidationUtils {
	public static void validatePositive(int value) {
		if (isNegative(value)) {
			throw new IllegalArgumentException(Message.INVALID_POSITIVE_NUMBER);
		}
	}

	private static boolean isNegative(int value) {
		return value < 0;
	}
}
