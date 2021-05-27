package lotto;

public class Profit {
	public static final double HUNDREDTHS_PLACE_POINT = 100.0;

	private final double rate;

	public Profit(Money totalWinAmount, Money totalAmount) {
		if (totalAmount.isZero()) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		rate = round(totalWinAmount.divide(totalAmount));
	}

	private double round(double value) {
		return Math.round(value * HUNDREDTHS_PLACE_POINT) / HUNDREDTHS_PLACE_POINT;
	}

	public double rate() {
		return rate;
	}
}
