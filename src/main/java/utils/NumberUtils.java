package utils;

import exception.LottoException;
import type.DecimalType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static type.LottoExceptionType.NEGATIVE_TEXT;

public class NumberUtils {
	private static final int INT_ZERO_VALUE = 0;
	private static final double DOUBLE_ZERO_VALUE = 0.0;
	private static final double DEFAULT_DOUBLE_VALUE = 0.0;

	private NumberUtils(){
		// empty
	}

	public static double mathRound(final double source, final double target, final DecimalType decimalType){
		if(target <= DOUBLE_ZERO_VALUE) return DEFAULT_DOUBLE_VALUE;
		double result = source / target;
		double decimalNumber = decimalType.value();
		return Math.round(result * decimalNumber) / decimalNumber;
	}

	public static int sumWithOutNegative(String[] texts) {
		return Arrays.stream(texts)
					 .mapToInt(Integer::parseInt)
					 .peek(NumberUtils::checkNegative)
					 .reduce(INT_ZERO_VALUE, Integer::sum);
	}

	private static void checkNegative(final int value){
		if(value < INT_ZERO_VALUE) {
			throw LottoException.of(NEGATIVE_TEXT);
		}
	}

	public static List<Integer> parseInts(final String[] texts, Predicate<Integer> condition){
		return Arrays.stream(texts)
					 .map(String::trim)
					 .map(Integer::parseInt)
					 .filter(condition)
					 .collect(Collectors.toList());
	}
}
