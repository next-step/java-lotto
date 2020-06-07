package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStringParser {

	public static List<Integer> numberStringToIntegerList(String numberValueString) {
		return Arrays.stream(numberValueString.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
	}
}
