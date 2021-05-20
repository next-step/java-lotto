package calculator;

import java.util.ArrayList;
import java.util.List;

class NonNegativeIntegers {

	private static final int ZERO = 0;

	private final List<Integer> list;

	NonNegativeIntegers(String[] strings) {
		list = new ArrayList<>(strings.length);
		addIntegers(strings);
	}

	private void addIntegers(String[] strings) {
		for (String string : strings) {
			list.add(parseInteger(string));
		}
	}

	private int parseInteger(String str) {
		int integer = Integer.parseInt(str);

		if (integer < ZERO) {
			throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
		}

		return integer;
	}

	int sum() {
		int result = 0;

		for (Integer integer : list) {
			result += integer;
		}

		return result;
	}

}
