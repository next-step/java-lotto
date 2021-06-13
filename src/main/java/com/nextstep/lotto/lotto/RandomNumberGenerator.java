package com.nextstep.lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator implements LottoNumberGenerator {

	private static final List<Integer> rangeNumbers;

	static {
		rangeNumbers = new ArrayList<>();
		for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
			rangeNumbers.add(i);
		}
	}

	@Override
	public Set<LottoNumber> makeNumbers() {
		Collections.shuffle(rangeNumbers);
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
			lottoNumbers.add(new LottoNumber(rangeNumbers.get(i)));
		}
		return lottoNumbers;
	}

	@Override
	public LottoNumber makeNumber() {
		return new LottoNumber(rangeNumbers.get(Lotto.LOTTO_SIZE));
	}
}
