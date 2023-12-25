package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Digits {
	private List<Digit> digits;

	public Digits(List<Digit> digits) {
		this.digits = digits;
	}

	public static List<Digit> create(int[] numbers) {
		List<Digit> digits = new ArrayList<>(6);
		for (int i = 0; i < numbers.length; i++) {
			digits.add(new Digit(numbers[i]));
		}
		return digits;
	}

	public List<String> digitToString() {
		List<String> numberText = new ArrayList<>(6);
		for (Digit digit : digits) {
			numberText.add(String.valueOf(digit.digit()));
		}
		return numberText;
	}
}
