package step1;

import java.util.ArrayList;
import java.util.List;

public class Separator {
	private static final String NUMBER_EXCEPTION_MESSAGE = "숫자만 계산할 수 있습니다";

	private final List<Integer> even = new ArrayList<>();

	private final List<String> odd = new ArrayList<>();

	public Separator(String input) {
		String[] split = input.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (checkEven(split, i))
				continue;
			odd.add(split[i]);
		}
	}

	private boolean checkEven(String[] split, int i) {
		if (i % 2 == 0) {
			validateNumber(split[i]);
			return true;
		}
		return false;
	}

	private void validateNumber(String split) {
		try {
			even.add(Integer.parseInt(split));
		} catch (Exception e) {
			throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
		}
	}

	public String getSignTerm(int index) {
		return odd.get(index);
	}

	public int getTerm() {
		return getTerm(0);
	}

	public int getTerm(int index) {
		return even.get(index);
	}

	public List<Integer> getTerms() {
		return this.even;
	}

	public List<String> getSigns() {
		return this.odd;
	}
}
