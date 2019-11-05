package lotto.dto;

import java.util.List;

public class InputLottoNumbers {

	private final List<Integer> inputNumbers;

	public InputLottoNumbers(List<Integer> inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	public List<Integer> getInputNumbers() {
		return inputNumbers;
	}

}
