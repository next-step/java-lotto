package step2.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

	public static final int SIZE = 6;
	private final Set<LottoNumber> numbers;

	public LottoNumbers(final Integer... numbers) {
		this(Arrays.stream(numbers)
			.map(LottoNumber::new)
			.collect(Collectors.toSet()));
	}

	public LottoNumbers(final Set<LottoNumber> numbers) {
		validateSize(numbers);
		this.numbers = numbers;
	}

	private void validateSize(final Set<LottoNumber> numbers) {
		if (SIZE != numbers.size()) {
			throw new IllegalArgumentException();
		}
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	public int size() {
		return numbers.size();
	}

	public LottoNumbers getWinningNumbers(final LottoNumbers winNumbers) {
		Set<LottoNumber> compareNumbers = new HashSet<>(this.numbers);
		compareNumbers.retainAll(winNumbers.getNumbers());
		return new LottoNumbers(compareNumbers);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final LottoNumbers that = (LottoNumbers)o;

		return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;
	}

	@Override
	public int hashCode() {
		return numbers != null ? numbers.hashCode() : 0;
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}

	public List<LottoNumber> getSortedList() {
		return this.numbers.stream()
			.sorted()
			.collect(Collectors.toList());
	}

	public boolean contains(final LottoNumber bonusNumber) {
		return this.getNumbers().contains(bonusNumber);
	}

}
