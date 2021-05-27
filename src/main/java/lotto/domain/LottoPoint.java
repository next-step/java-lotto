package lotto.domain;

import java.util.Objects;

public class LottoPoint {

	private final int point;
	private final boolean bonus;

	public LottoPoint(int point) {
		this.point = point;
		bonus = false;
	}

	public LottoPoint(int point, boolean bonus) {
		this.point = point;
		this.bonus = bonus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoPoint that = (LottoPoint)o;
		return point == that.point && bonus == that.bonus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(point, bonus);
	}
}
