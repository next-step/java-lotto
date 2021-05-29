package lotto.game.domain.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lotto.game.exception.IllegalBallNumberException;
import lotto.io.domain.vo.InputText;

public class Ball implements Comparable<Ball> {
	public static final int EFFECTIVE_MIN_NUMBER = 1;
	public static final int EFFECTIVE_MAX_NUMBER = 45;
	public static final Map<Integer, Ball> ALL_BALL_INSTANCES = new HashMap<>();

	private final int number;

	private Ball(int number) {
		this.number = number;
	}

	static {
		for (int i = EFFECTIVE_MIN_NUMBER; i <= EFFECTIVE_MAX_NUMBER; i++) {
			ALL_BALL_INSTANCES.put(i, new Ball(i));
		}
	}

	public static Ball of(InputText text) {
		validateGenerate(text);
		return ALL_BALL_INSTANCES.get(text.parseInt());
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
