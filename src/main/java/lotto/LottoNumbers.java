package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
	public static final String NOT_SIX_NUMBER = "로또 숫자가 6개가 아닙니다.";
	public static final String HAVE_SAME_NUMBER = "중복되는 숫자가 있습니다.";
	public static final int LOTTO_NUMBER_COUNT = 6;
	private final List<LottoNumber> numbers;

	public LottoNumbers(List<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(NOT_SIX_NUMBER);
		}

		Set<LottoNumber> union = new HashSet<>();
		numbers.forEach(number -> union.add(number));
		if (union.size() != numbers.size()) {
			throw new IllegalArgumentException(HAVE_SAME_NUMBER);
		}
		this.numbers = numbers;
	}

	public int matchedCount(LottoNumbers other) {
		return (int)this.numbers.stream().filter((number -> other.contains(number))).count();
	}

	private boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}
}
