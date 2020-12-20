package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private static final List<LottoNumber> availableLottoNumbers;

	static {
		availableLottoNumbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());
	}

	public static LottoNumbers generate() {
		shuffle();
		return new LottoNumbers(availableLottoNumbers.stream()
			.limit(LottoNumbers.MAX_SIZE)
			.collect(Collectors.toSet()));
	}

	private static void shuffle() {
		Collections.shuffle(availableLottoNumbers);
	}

}
