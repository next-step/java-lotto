package utils;

import exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static exception.LottoExceptionType.NEGATIVE_TEXT;

public class NumberUtils {

	public static double mathRound(final double source, final double target, final DecimalType decimalType){
		if(target == 0.0) return 0.0;
		double result = source / target;
		double decimalNumber = decimalType.value();
		return Math.round(result * decimalNumber) / decimalNumber;
	}

	public static int sumWithOutNegative(String[] texts) {
		return Arrays.stream(texts)
					 .mapToInt(Integer::parseInt)
					 .peek(NumberUtils::checkNegative)
					 .reduce(0, Integer::sum);
	}

	private static void checkNegative(final int value){
		if(value < 0) {
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
