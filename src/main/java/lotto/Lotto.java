package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private final List<Integer> lottoNumbers;

	public Lotto(LottoNumberStrategy strategy) {
		this.lottoNumbers = strategy.generateLottoNumber();
		Collections.sort(this.lottoNumbers);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean isMatched(int number) {
		return lottoNumbers.contains(number);
	}

	public String getLottoNumbersString() {
		return lottoNumbers.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", ", "[", "]"));
	}
}
