package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
	private final List<Integer> numbers;

	public LottoNumbers(List<Integer> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
