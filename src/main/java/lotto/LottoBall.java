package lotto;

import java.util.Objects;

public class LottoBall {

	private static final int LOTTO_MAX_NUMBER = 45;

	private static final int LOTTO_MIN_NUMBER = 1;
	
	// 로또 단일 번호
	private int ball;
	
	public LottoBall(int ball) {
		this.validate(ball);
		this.ball = ball;
	}
	
	private void validate(int ball) {
		if(ball < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < ball) {
			throw new IllegalArgumentException("로또 숫자의 범위는 1 ~ 45 입니다.");
		}
	}

	public int getBall() {
		return ball;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}

		if(obj instanceof LottoBall == false) {
			return false;
		}

		return this.ball == ((LottoBall) obj).ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ball);
	}
}
