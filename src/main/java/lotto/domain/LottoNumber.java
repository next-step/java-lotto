package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
	private List<Integer> lottoNumber;

	public List<Integer> getLottoNumber() {
		return lottoNumber;
	}

	public void generate(NumberGenerator numberGenerator) {
		this.lottoNumber = numberGenerator.generateNumbers();
	}

	@Override
	public String toString() {
		return "["+lottoNumber.stream().map(ln -> Integer.toString(ln)).collect(Collectors.joining(", "))+"]";
	}
}
