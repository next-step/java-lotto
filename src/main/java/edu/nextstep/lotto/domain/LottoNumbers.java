package edu.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<Integer> numbers) {
		this.lottoNumbers = numbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}
}
