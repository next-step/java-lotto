package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoNumberDto {
	private final List<Integer> numbers;

	public LottoNumberDto(List<Integer> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
