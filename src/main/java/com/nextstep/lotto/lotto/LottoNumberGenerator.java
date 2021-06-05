package com.nextstep.lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberGenerator {

	private final List<Integer> rangeNumbers;

	public LottoNumberGenerator() {
		rangeNumbers = new ArrayList<>();
		for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
			rangeNumbers.add(i);
		}
	}

	public Set<LottoNumber> makeRandomNumbers() {
		Collections.shuffle(rangeNumbers);
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
			lottoNumbers.add(new LottoNumber(rangeNumbers.get(i)));
		}
		return lottoNumbers;
	}
}
