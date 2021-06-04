package com.nextstep.lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

	private List<Integer> rangeNumbers;

	public LottoNumberGenerator() {
		rangeNumbers = new ArrayList<>();
		for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
			rangeNumbers.add(i);
		}
	}

	public List<LottoNumber> makeRandomNumbers() {
		Collections.shuffle(rangeNumbers);
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
			lottoNumbers.add(new LottoNumber(rangeNumbers.get(i)));
		}
		return lottoNumbers;
	}
}
