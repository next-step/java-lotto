package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

	private final List<LottoNo> lottoEnableNumbers = new ArrayList<>();

	public LottoAutoGenerator() {
		IntStream.rangeClosed(LottoNo.LOTTO_START_NUMBER, LottoNo.LOTTO_END_NUMBER)
			.forEach(number -> lottoEnableNumbers.add(LottoNo.of(number)));
	}

	@Override
	public List<LottoNo> generate() {
		Collections.shuffle(lottoEnableNumbers);
		return lottoEnableNumbers.subList(0, Lotto.LOTTO_NUMBER_LENGTH);
	}
}
