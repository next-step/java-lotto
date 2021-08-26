package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Number;

public class StringUtils {
	private static final String SPACE_VALUE = " ";
	private static final String EMPTY_VALUE = "";
	private static final String SPLIT_DELIMITER = ",";

	public static List<Number> convertToNumberList(String strList) {
		String[] splitStr = strList.replace(SPACE_VALUE, EMPTY_VALUE).split(SPLIT_DELIMITER);
		return Arrays.stream(splitStr)
			.map(Integer::parseInt)
			.map(Number::new)
			.collect(Collectors.toList());
	}
}
