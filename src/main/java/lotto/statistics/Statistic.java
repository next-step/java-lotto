package lotto.statistics;

import java.util.Objects;

public class Statistic {

	private final Earn earn;
	private int count;
	public Statistic(int repeatedCount, Earn earn) {
		this.count = repeatedCount;
		this.earn = earn;
	}

	public int earningPrice() {
		return count * earn.winningPrice();
	}

	public Statistic plusMatchCount() {
		count++;
		return this;
	}

	public String earningMessage() {
		return earn.message(count);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Statistic))
			return false;
		Statistic statistic = (Statistic)o;
		return count == statistic.count && earn == statistic.earn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, earn);
	}
}
