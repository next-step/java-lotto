package step2.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFixedNumberGenerator implements LottoNumberGenerator {
	public static final int LOTTO_NUMBER_LENGTH = 6;

	private final List<Integer> fixedNumbers;

	private LottoFixedNumberGenerator(List<Integer> fixedNumbers) {
		this.fixedNumbers = fixedNumbers;
	}

	public static LottoFixedNumberGenerator from(List<Integer> fixedNumbers) {
		if (fixedNumbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}

		return new LottoFixedNumberGenerator(fixedNumbers);
	}

	public static LottoFixedNumberGenerator createSequential(int startIndex) {
		List<Integer> numbers = IntStream.range(startIndex, startIndex + LOTTO_NUMBER_LENGTH)
			.boxed()
			.collect(Collectors.toList());

		return new LottoFixedNumberGenerator(numbers);
	}

	public LottoFixedNumberGenerator shuffle() {
		Collections.shuffle(fixedNumbers);

		return this;
	}

	@Override
	public List<Integer> generate() {
		return fixedNumbers;
	}
}
