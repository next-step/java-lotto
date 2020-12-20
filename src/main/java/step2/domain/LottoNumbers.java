package step2.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

	public static final int MAX_SIZE = 6;
	private final Set<LottoNumber> numbers;

	public LottoNumbers(final Integer... winNumbers) {
		this(Arrays.stream(winNumbers)
			.map(LottoNumber::new)
			.collect(Collectors.toSet()));
	}

	public LottoNumbers(final Set<LottoNumber> numbers) {
		validateSize(numbers);
		this.numbers = numbers;
	}

	private void validateSize(final Set<LottoNumber> numbers) {
		if (MAX_SIZE != numbers.size()) {
			throw new IllegalArgumentException();
		}
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	public int size() {
		return numbers.size();
	}

	public LottoNumbers getWinningNumbers(final Integer... winNumbers) {
		Set<LottoNumber> compareNumbers = new HashSet<>(this.numbers);
		compareNumbers.retainAll(new LottoNumbers(winNumbers).getNumbers());
		return new LottoNumbers(compareNumbers);
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}

}
