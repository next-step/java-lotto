package com.nextstep.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

	private static final int LOTTO_SIZE = 6;
	private List<LottoNumber> lottoNumbers;

	public Lotto() {
		generateNumbers();
	}

	private void generateNumbers() {
		List<Integer> numberList = new ArrayList<>();
		for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
			numberList.add(i);
		}
		lottoNumbers = makeRandomNumber(numberList);
	}

	public List<LottoNumber> getLottoNumbers() {
		return this.lottoNumbers;
	}

	public int size() {
		return this.lottoNumbers.size();
	}

	private List<LottoNumber> makeRandomNumber(List<Integer> numberList) {
		Collections.shuffle(numberList);
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			lottoNumbers.add(new LottoNumber(numberList.get(i)));
		}
		return lottoNumbers;
	}
}
