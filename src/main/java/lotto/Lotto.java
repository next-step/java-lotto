package lotto;

import static lotto.LottoGenerator.*;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lotto {

	private final SortedSet<LottoNumber> numbers;

	public Lotto(Set<LottoNumber> numbers) {
		validateNumbers(numbers);

		this.numbers = new TreeSet<>(numbers);
	}

	private static void validateNumbers(Set<LottoNumber> numbers) {
		if (numbers.size() != REQUIRED_COUNT) {
			throw new InvalidNumberSetException("로또는 서로 다른 6개의 숫자로 구성되어야 합니다.");
		}
	}

	public long matchCount(Lotto winLotto) {
		return numbers.stream()
				.filter(winLotto.numbers::contains)
				.count();
	}

	public boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
