package study;

import java.util.ArrayList;
import java.util.List;

public class NonNegativeIntegers {

	private final List<NonNegativeInteger> list;

	public NonNegativeIntegers(String[] strings) {
		list = new ArrayList<>(strings.length);
		addIntegers(strings);
	}

	private void addIntegers(String[] strings) {
		for (String string : strings) {
			list.add(new NonNegativeInteger(string));
		}
	}

	public int sum() {
		int result = 0;

		for (NonNegativeInteger integer : list) {
			result += integer.get();
		}

		return result;
	}
}
