package com.nextstep.lotto.model;

import java.util.List;

public class Lotto {

	public static final int LOTTO_SIZE = 6;
	private List<LottoNumber> lottoNumbers;

	public Lotto() {
		generateNumbers();
	}

	public List<LottoNumber> getLottoNumbers() {
		return this.lottoNumbers;
	}

	public int size() {
		return this.lottoNumbers.size();
	}

	private void generateNumbers() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		lottoNumbers = lottoNumberGenerator.getRandomNumbers();
	}
}
