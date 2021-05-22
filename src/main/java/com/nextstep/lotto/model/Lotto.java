package com.nextstep.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private static final int LOTTO_SIZE = 6;
	private List<LottoNumber> lottoNumbers;

	public Lotto() {
		generateNumbers();
	}

	private void generateNumbers() {
		lottoNumbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			lottoNumbers.add(new LottoNumber(i + 1));
		}
	}

	public List<LottoNumber> getLottoNumbers() {
		return this.lottoNumbers;
	}

	public int size() {
		return this.lottoNumbers.size();
	}
}
