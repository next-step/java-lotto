package step2.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import step2.lotto.domain.LottoNumber;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
	public static final int LOTTO_NUMBER_MIN = 1;
	public static final int LOTTO_NUMBER_MAX = 45;

	public static final int LOTTO_NUMBER_LENGTH = 6;

	public static LottoRandomNumberGenerator create() {
		return new LottoRandomNumberGenerator();
	}

	@Override
	public List<LottoNumber> generate() {
		List<Integer> numbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
			.boxed()
			.collect(Collectors.toList());

		Collections.shuffle(numbers);

		return convertLottoNumbers(numbers);
	}

	private static List<LottoNumber> convertLottoNumbers(List<Integer> numbers) {
		return numbers.subList(0, LOTTO_NUMBER_LENGTH)
			.stream()
			.map(LottoNumber::from)
			.collect(Collectors.toList());
	}
}
