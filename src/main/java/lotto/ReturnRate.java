package lotto;

import java.util.Objects;

public class ReturnRate {
	private static final double MIN_VALUE = 0;
	private static final int ROUND_POSITION = 100;

	private final double returnRate;

	private ReturnRate(double returnRate) {
		validate(returnRate);
		this.returnRate = round(returnRate);
	}

	private double round(double returnRate) {
		return (double) Math.round(returnRate * ROUND_POSITION / ROUND_POSITION);
	}

	private void validate(double returnRate) {
		if (returnRate < MIN_VALUE) {
			throw new IllegalArgumentException("수익률은 0.0 이상입니다.");
		}
	}

	public static ReturnRate of(double returnRate) {
		return new ReturnRate(returnRate);
	}

	public static ReturnRate calculate(int moneyAmount, LottoResults lottoResults) {
		Money sumMoney = lottoResults.sumResultMoney();
		Money purchaseMoney = Money.of(moneyAmount);
		return new ReturnRate(sumMoney.divide(purchaseMoney));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ReturnRate that = (ReturnRate)obj;
		return Double.compare(that.returnRate, returnRate) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(returnRate);
	}
}
