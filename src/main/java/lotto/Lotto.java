package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	public static final String NOT_SIX_NUMBER = "로또 숫자가 6개가 아닙니다.";
	public static final String HAVE_SAME_NUMBER = "중복되는 숫자가 있습니다.";
	public static final int LOTTO_NUMBER_COUNT = 6;
	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(NOT_SIX_NUMBER);
		}

		Set<Integer> union = new HashSet<>();
		numbers.forEach(number -> union.add(number));
		if (union.size() != numbers.size()) {
			throw new IllegalArgumentException(HAVE_SAME_NUMBER);
		}

		this.lottoNumbers = numbers
			.stream()
			.map(number -> new LottoNumber(number))
			.collect(Collectors.toList());
	}

	public int matchedCount(Lotto other) {
		Set<LottoNumber> union = new HashSet<>();
		this.lottoNumbers.forEach(lotto -> union.add(lotto));
		other.lottoNumbers.forEach(lotto -> union.add(lotto));

		return this.lottoNumbers.size() + other.lottoNumbers.size() - union.size();
	}
}
