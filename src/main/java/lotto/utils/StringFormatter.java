package lotto.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringFormatter {
	public static <T> String listToString(List<T> list) {
		return list.stream()
				.map(Objects::toString)
				.collect(Collectors.joining(",", "[", "]"));
	}
}
