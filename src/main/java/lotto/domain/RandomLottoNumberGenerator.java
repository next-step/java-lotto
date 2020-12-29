package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
	private static final List<LottoNumber> LOTTO_NUMBERS;

	static {
		LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());
	}

	@Override
	public List<LottoNumber> generate() {
		Collections.shuffle(LOTTO_NUMBERS);

		return new ArrayList<>(LOTTO_NUMBERS.subList(0, LottoLottery.LOTTO_NUMBER_COUNT));
	}
}
