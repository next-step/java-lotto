package lotto.ui.input.validation;

import lotto.core.Ball;
import lotto.core.SixBall;

public class InputValidation {
	public boolean bonusBallValidation(int[] fix, int bonus) {
		int index = 0;
		if (fix[index++] == bonus) {
			throw new IllegalArgumentException("보너스 볼이 당첨 번호에 포함되어 있습니다.");
		}

		return ballValidation(bonus);
	}

	public boolean ballValidation(int bonus) {
		if (Ball.validation(bonus)) {
			throw new IllegalArgumentException(String.format("번호는 %d이상 %d이하의 숫자만 존재할수있습니다.", Ball.MIN, Ball.MAX));
		}

		return true;
	}

	public boolean winningSixBallValidation(int[] fixs) {
		if (fixs.length < SixBall.LENGTH) {
			throw new IllegalArgumentException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
		}

		return true;
	}
}
