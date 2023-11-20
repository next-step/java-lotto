package lotto.domain.util;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {
	public static List<Integer> convertToIntegerList(String str) {
		String[] winningNums = str.split(", ");
		List<Integer> winningNumToInteger = new ArrayList<>();
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
