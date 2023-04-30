package lotto.domain;

import java.util.Objects;

public class Score {

	private static final int MAX_SCORE = 6;

	private int score;

	public Score(int score) {
		if (score < 0) {
			throw new IllegalArgumentException("점수는 음수일 수 없습니다.");
		}
		this.score = score;
	}

	public void plus() {
		this.score++;
	}

	public boolean lessThan() {
		return this.score < Score.MAX_SCORE;
	}

	public int getScore() {
		return score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Score score1 = (Score)o;
		return score == score1.score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(score);
	}
}
