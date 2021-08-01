package lotto.exception;

import java.util.List;

public class InvalidBonusNumberException extends RuntimeException {

	private static final String MESSAGE = "보너스 번호가 당첨 번호와 중복됩니다.\n(당첨 번호: %s, 보너스 번호: %d)";

	public InvalidBonusNumberException(List<Integer> winningNumbers, int bonusNumber) {
		super(String.format(MESSAGE, winningNumbers, bonusNumber));
	}
}
