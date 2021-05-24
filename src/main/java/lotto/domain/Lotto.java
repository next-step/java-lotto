package lotto.domain;

import java.util.List;

public class Lotto {

	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_NUMBER_SIZE = 6;

	private final List<LottoNumber> numbers;

	public Lotto(final List<LottoNumber> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public long getMatchesCount(Lotto lotto) {
		return lotto.numbers.stream()
			.filter(this::containNumber)
			.count();
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}

	@Override
	public boolean equals(Object lotto) {
		if (lotto instanceof Lotto) {
			Lotto anotherLotto = (Lotto)lotto;
			return this.numbers == anotherLotto.numbers;
		}
		return false;
	}

	public boolean containNumber(LottoNumber number) {
		return this.numbers.contains(number);
	}

	private void validate(List<LottoNumber> numbers) {
		if (numbers.size() > LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("6개 보다 크다");
		}
	}
}
