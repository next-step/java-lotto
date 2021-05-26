package lotto.game.domain.vo;

import java.util.Objects;

import lotto.game.exception.IllegalBallNumberException;
import lotto.io.domain.vo.InputText;

public class Ball implements Comparable<Ball> {
	public static final int EFFECTIVE_MIN_NUMBER = 1;
	public static final int EFFECTIVE_MAX_NUMBER = 45;

	private int number;

	private Ball(InputText text) {
		this.number = parse(text);
	}

	private static int parse(InputText text) {
		return Integer.parseInt(text.value());
	}

	public static Ball generate(InputText text) throws IllegalBallNumberException {
		validateGenerate(text);
		return new Ball(text);
	}

	static void validateGenerate(InputText text) throws IllegalBallNumberException {
		validateNumberFormat(text);
		validateEffectiveNumber(text);
	}

	private static void validateEffectiveNumber(InputText text) throws IllegalBallNumberException {
		int number = parse(text);
		if (!isEffectiveNumber(number)) {
			throw new IllegalBallNumberException("볼 넘버는 "
				+ EFFECTIVE_MIN_NUMBER + "~" + EFFECTIVE_MAX_NUMBER + "까지의 자연수만 가능합니다. "
				+ "입력된 값 : " + number);
		}
	}

	private static boolean isEffectiveNumber(int number) {
		return EFFECTIVE_MIN_NUMBER <= number && number <= EFFECTIVE_MAX_NUMBER;
	}

	private static void validateNumberFormat(InputText text) throws IllegalBallNumberException {
		try {
			parse(text);
		} catch (NumberFormatException e) {
			throw new IllegalBallNumberException("Integer 값으로 parsing할 수 없습니다. 입력된 값 : " + text.value());
		}
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
		Ball ball = (Ball)object;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public int compareTo(Ball ball) {
		if (this.number() > ball.number()) {
			return 1;
		}
		if (this.number() < ball.number()) {
			return -1;
		}
		return 0;
	}
}
