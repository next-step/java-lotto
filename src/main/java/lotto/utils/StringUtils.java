package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
	private static final String SPACE_VALUE = " ";
	private static final String EMPTY_VALUE = "";
	private static final String SPLIT_DELIMITER = ",";

	public static List<Integer> convertToNumberList(String strList) {
		String[] splitStr = strList.replace(SPACE_VALUE, EMPTY_VALUE).split(SPLIT_DELIMITER);
		return Arrays.stream(splitStr)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
