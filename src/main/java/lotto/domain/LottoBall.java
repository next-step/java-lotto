package lotto.domain;

import java.util.Objects;

public class LottoBall {
	public static final int LOTTO_BALL_NUMBER_MIN = 1;
	public static final int LOTTO_BALL_NUMBER_MAX = 45;

	private final int number;

	protected LottoBall(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (number < LOTTO_BALL_NUMBER_MIN) {
			throw new RuntimeException("입력된 로또숫자가 " + LOTTO_BALL_NUMBER_MIN + "미만입니다.");
		}

		if (number > LOTTO_BALL_NUMBER_MAX) {
			throw new RuntimeException("입력된 로또숫자가 " + LOTTO_BALL_NUMBER_MAX + "초과합니다.");
		}
	}

	// "이펙티브 자바 : 아이템1 생성자 대신 정적 팩터리 메서드를 고려하라" 참고
	public static LottoBall from(int number) {
		return new LottoBall(number);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		LottoBall lottoBall = (LottoBall)object;
		return number == lottoBall.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
