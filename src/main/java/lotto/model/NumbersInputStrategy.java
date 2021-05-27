package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersInputStrategy implements LottoNumbersGenerateStrategy {
	private final List<List<Integer>> inputNumbers;

	public NumbersInputStrategy(List<List<Integer>> inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	@Override
	public List<LottoNumbers> generate() {
		return inputNumbers.stream()
			.map(LottoNumbers::of)
			.collect(Collectors.toList());
	}
}
