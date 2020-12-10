package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

	private final List<Integer> lottoEnableNumbers = new ArrayList<>();

	public LottoAutoGenerator() {
		IntStream.range(Lotto.LOTTO_START_NUMBER, Lotto.LOTTO_END_NUMBER + 1)
			.forEach(lottoEnableNumbers::add);
	}

	@Override
	public List<Integer> generate() {
		Collections.shuffle(lottoEnableNumbers);
		return lottoEnableNumbers.subList(0, Lotto.LOTTO_NUMBER_LENGTH);
	}
}
