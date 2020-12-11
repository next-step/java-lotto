package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
	private final List<LottoNumber> numbers;

	public LottoNumbers(List<LottoNumber> numbers) {
		this.numbers = numbers.stream()
			.sorted(LottoNumber::isGraterThanNumber).collect(Collectors.toList());
	}

	public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
		return this.numbers.contains(lottoNumber);
	}

	public int isContainsCount(LottoNumbers winningNumber) {
		return (int) winningNumber.numbers.stream().filter(this::isContainsLottoNumber).count();
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
}
