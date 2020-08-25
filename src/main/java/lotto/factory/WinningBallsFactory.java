package lotto.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.BonusBall;
import lotto.Lotto;
import lotto.WinningBalls;
import lotto.input.InputValidator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WinningBallsFactory {

	public static WinningBalls create(String numbersString, String bonusBallString) {
		InputValidator.validateWinningNumbers(numbersString);
		Lotto winningNumbers = LottoFactory.createBy(numbersString);
		return WinningBalls.of(winningNumbers, BonusBall.of(bonusBallString));
	}
}
