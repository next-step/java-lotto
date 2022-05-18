package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomGenerator {
	private static final List<LottoNumber> defaultNumbers = IntStream.rangeClosed(LottoNumber.LOTTO_RANGE_MIN, LottoNumber.LOTTO_RANGE_MAX)
		.mapToObj(LottoNumber::of)
		.collect(Collectors.toList());

	private LottoRandomGenerator() {}

	public static List<LottoNumber> generate(int size) {
		Collections.shuffle(defaultNumbers);

		return new ArrayList<>(defaultNumbers.subList(0, size));
	}
}
