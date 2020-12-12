package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LottoNumbers {
	public static final int MAX_LOTTO_NUMBERS_SIZE = 6;
	private Set<LottoNumber> numbers;

	public LottoNumbers(List<LottoNumber> numbers) {
		addLottoNumbersAll(numbers);
	}

	private void addLottoNumbersAll(List<LottoNumber> numbers) {
		this.numbers = Optional.of(numbers)
			.map(HashSet::new)
			.filter(lottoNumbers -> verifyDuplicate(lottoNumbers.size(), numbers.size()))
			.filter(lottoNumbers -> verifyNumbersSize(lottoNumbers.size()))
			.orElseThrow(IllegalArgumentException::new);
	}

	public Set<LottoNumber> getNumbers() {
		return this.numbers;
	}

	private boolean verifyDuplicate(int base, int target) {
		if (base < target) {
			throw new IllegalArgumentException("중복된 데이터가 있습니다.");
		}
		return true;
	}

	private boolean verifyNumbersSize(int size) {
		if (size > MAX_LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또 숫자개수는 6을 초과할수 없습니다.");
		}
		return true;
	}

	public int getContainsCount(LottoNumbers targetNumbers) {
		return Optional.of(this.numbers
			.stream()
			.filter(targetNumbers::isContainsLottoNumber)
			.count())
			.orElse(0L)
			.intValue();
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
