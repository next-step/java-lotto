package lotto.utils;

import java.util.List;
import java.util.Objects;

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

	public static <T> void validateEmpty(List<T> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			throw new IllegalArgumentException(Message.INVALID_EMPTY_LIST);
		}
	}
}
