package com.nextstep.lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Lotto {

	public static final int LOTTO_SIZE = 6;
	private static final String STRING_DELIMITER = ", ";
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

	public void print() {
		Collections.sort(lottoNumbers);
		StringJoiner stringJoiner = new StringJoiner(STRING_DELIMITER);
		for (LottoNumber lottoNumber : lottoNumbers) {
			stringJoiner.add(String.valueOf(lottoNumber.getNumber()));
		}
		System.out.println("[" + stringJoiner + "]");
	}

	private void generateNumbers() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		lottoNumbers = lottoNumberGenerator.getRandomNumbers();
	}
}
