package lotto.game.domain.vo;

import java.util.Objects;

import lotto.game.exception.IllegalBallNumberException;
import lotto.io.domain.vo.InputText;

public class Ball implements Comparable<Ball> {
	public static final int EFFECTIVE_MIN_NUMBER = 1;
	public static final int EFFECTIVE_MAX_NUMBER = 45;

	private final int number;

	private Ball(InputText text) {
		this.number = text.parseInt();
	}

	public static Ball generate(InputText text) {
		validateGenerate(text);
		return new Ball(text);
	}

	static void validateGenerate(InputText text) {
		InputText.validateNumberFormatInputText(text);
		validateEffectiveNumber(text.parseInt());
	}

	private static void validateEffectiveNumber(int number) {
		if (!isEffectiveNumber(number)) {
			throw new IllegalBallNumberException("볼 넘버는 "
				+ EFFECTIVE_MIN_NUMBER + "~" + EFFECTIVE_MAX_NUMBER + "까지의 자연수만 가능합니다. "
				+ "입력된 값 : " + number);
		}
	}

	private static boolean isEffectiveNumber(int number) {
		return EFFECTIVE_MIN_NUMBER <= number && number <= EFFECTIVE_MAX_NUMBER;
	}

	public int number() {
		return this.number;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Ball)) {
			return false;
		}
		Ball ball = (Ball) object;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public int compareTo(Ball ball) {
		return Integer.compare(this.number(), ball.number());
	}
}
