package lotto;

public class Profit {
	public static final double PERCENT_RATE = 100.0;

	private final double rate;

	public Profit(Money totalWinAmount, Money totalAmount) {
		if (totalAmount.isZero()) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		this.rate = totalWinAmount.divide(totalAmount);
	}

	public double rate() {
		return Math.round(rate * PERCENT_RATE) / PERCENT_RATE; // 소수점 둘째 자리까지
	}
}
