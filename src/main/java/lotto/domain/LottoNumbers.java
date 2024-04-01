package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	private final List<Integer> lottoNumbers;

	public LottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean isMatched(int number) {
		return lottoNumbers.contains(number);
	}
}
