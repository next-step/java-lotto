package lotto;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.List;

public class InputLottoNumberStrategy implements LottoNumberStrategy {
	private final List<Integer> inputNumbers;

	public InputLottoNumberStrategy(List<Integer> inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	@Override
	public List<Integer> generateLottoNumber() {
		return inputNumbers;
	}
}
