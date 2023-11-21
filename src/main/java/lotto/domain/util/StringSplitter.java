package lotto.domain.util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringSplitter {
	public static Set<Integer> convertToIntegerSet(String str) {
		String[] winningNums = str.split(", ");
		Set<Integer> winningNumToInteger = new LinkedHashSet<>();
		for (String num : winningNums) {
			winningNumToInteger.add(strToInt(num));
		}
		return winningNumToInteger;
	}

	private static Integer strToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("해당 문자열을 숫자로 변환할 수 없습니다.");
		}
	}
}
