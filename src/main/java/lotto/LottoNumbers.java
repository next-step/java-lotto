package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final String INVALID_NUMBER_COUNT = "로또 숫자의 갯수가 맞지 않습니다.";
	public static final String HAVE_SAME_NUMBER = "중복되는 숫자가 있습니다.";
	public static final int LOTTO_NUMBER_COUNT = 6;
	private final List<LottoNumber> numbers;

	public LottoNumbers(List<Integer> numbers) {
		this(numbers, LOTTO_NUMBER_COUNT);
	}

	public LottoNumbers(List<Integer> numbers, int lottoNumberCount) {
		if (numbers.size() != lottoNumberCount) {
			throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
		}

		Set<Integer> union = new HashSet<>();
		numbers.forEach(number -> union.add(number));
		if (union.size() != numbers.size()) {
			throw new IllegalArgumentException(HAVE_SAME_NUMBER);
		}
		this.numbers = numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

	public int matchedCount(LottoNumbers other) {
		return (int)this.numbers.stream().filter((number -> other.contains(number))).count();
	}

	private boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}
}
