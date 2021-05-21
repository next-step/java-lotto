package lotto;

public class Profit {
	public static final double PERCENT_RATE = 100.0;
	private final double rate;

	public Profit(int totalWinAmount, int totalAmount) {
		this.rate = (double)totalWinAmount / totalAmount;
	}

	public double rate() {
		return Math.round(rate * PERCENT_RATE) / PERCENT_RATE;
	}
}
