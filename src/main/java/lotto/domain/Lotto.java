package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {

	public static final int NUMBER_COUNT = 6;

	private List<LottoNumber> numbers;

	public Lotto(List<LottoNumber> numbers) {
		if(hasDuplicatedNumber(numbers)) {
			throw new IllegalArgumentException(
					String.format("중복되지 않은 숫자 %d개만 가능합니다.",
							 NUMBER_COUNT));
		}
		this.numbers = numbers;
	}

	private boolean hasDuplicatedNumber(List<LottoNumber> numbers) {
		int count = (int) numbers.stream()
				.distinct()
				.count();
		return count != NUMBER_COUNT;
	}

	public int match(Lotto lotto) {
		int match = 0;
		for(LottoNumber number : numbers) {
			if(lotto.hasNumber(number)) {
				++match;
			}
		}
		return match;
	}

	public boolean hasNumber(LottoNumber number) {
		return numbers.contains(number);
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers.toArray());
	}
}
