package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_NUMBER_SIZE = 6;

	private final List<LottoNumber> numbers;

	public Lotto(final List<LottoNumber> numbers) {
		validate(numbers);
		this.numbers = numbers;
		sort();
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

	private void validate(List<LottoNumber> checkNumbers) {
		validateCount(checkNumbers);
		validateDuplicate(checkNumbers);
	}

	private void validateCount(List<LottoNumber> checkNumbers) {
		if (checkNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개여만 합니다.");
		}
	}

	private void validateDuplicate(List<LottoNumber> checkNumbers) {
		Set<LottoNumber> checkNumberSet = new HashSet(checkNumbers);
		if(checkNumberSet.size() != LOTTO_NUMBER_SIZE)
			throw new IllegalArgumentException("로또에 중복된 번호가 있습니다.");
	}

	private void sort() {
		Collections.sort(this.numbers);
	}
}
