package automaticLotto.domain;

public class ProfitRate {
	double profitRate;

	public ProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}

	public String getProfitRate() {
		return String.format("%.2f", profitRate);
	}

	public String getResult() {
		String profit = "이익이";

		if (profitRate == 1) {
			profit = "쌤썜이";
		}

		if (profitRate < 1) {
			profit = "손해";
		}

		return profit;
	}
}
