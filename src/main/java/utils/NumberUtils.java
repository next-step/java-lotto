package utils;

import exception.StringAddCalculatorException;
import type.DecimalType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static type.StringAddCalculatorExceptionType.NEGATIVE_TEXT;

public class NumberUtils {
	private static final int INT_ZERO_VALUE = 0;

	private NumberUtils(){
		// empty
	}

	public static BigDecimal mathRound(final BigDecimal source, final BigDecimal target, final DecimalType decimalType) {
		return source.divide(target, decimalType.value(), RoundingMode.HALF_UP);
	}

	public static int sumWithOutNegative(String[] texts) {
		return Arrays.stream(texts)
					 .mapToInt(Integer::parseInt)
					 .peek(NumberUtils::checkNegative)
					 .reduce(INT_ZERO_VALUE, Integer::sum);
	}

	private static void checkNegative(final int value) {
		if (value < INT_ZERO_VALUE) {
			throw StringAddCalculatorException.of(NEGATIVE_TEXT);
		}
	}

	public static List<Integer> parseInts(final String[] texts, Predicate<Integer> condition) {
		return Arrays.stream(texts)
					 .map(String::trim)
					 .map(Integer::parseInt)
					 .filter(condition)
					 .collect(Collectors.toList());
	}
}
