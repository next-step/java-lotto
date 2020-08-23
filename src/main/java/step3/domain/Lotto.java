package step3.domain;

import java.util.*;

public class Lotto {
	private final Set<LottoNumber> numbers;

	private static final int LOTTO_NUMBER_LENGTH = 6;
	private static final String LOTTO_PHRASES = "로또 번호는 중복되지 않는 6개의 숫자로 이루어져야 합니다.";

	public Lotto(List<LottoNumber> numbers) {
		this.numbers = new LinkedHashSet<>(numbers);
		validLotto();
	}

	private void validLotto() {
		if (numbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException(LOTTO_PHRASES);
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers.toArray());
	}

	public int getMatchCount(Lotto otherLotto) {
		return (int) numbers.stream()
				.filter(otherLotto::containNumber)
				.count();
	}

	public boolean containNumber(LottoNumber number) {
		return numbers.contains(number);
	}
}
