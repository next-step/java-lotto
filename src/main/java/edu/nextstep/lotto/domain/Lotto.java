package edu.nextstep.lotto.domain;

import java.util.List;

public class Lotto {
	public static final int PRICE = 1000;
	private final LottoNumbers lottoNumbers;

	public Lotto(List<Integer> numbers) {
		this.lottoNumbers = new LottoNumbers(numbers);
	}
}