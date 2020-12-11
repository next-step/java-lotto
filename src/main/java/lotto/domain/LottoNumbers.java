package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
	private final List<LottoNumber> numbers;

	public LottoNumbers(List<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public List<LottoNumber> getNumbers() {
		return numbers;
	}

	public boolean isContainsLottoNumber(LottoNumber baseNumber) {
		return this.numbers.contains(baseNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumbers that = (LottoNumbers) o;

		for (LottoNumber element : that.numbers) {
			if (!this.numbers.contains(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

	@Override
	public String toString() {
		return String.valueOf(numbers);
	}
}
