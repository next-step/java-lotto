package lotto.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PrizeRate {

	public static final String NUMBER_FORMAT_PATTERN = "0.##";

	private PrizeRate() {
	}

	public static String getPrizeEarningRate(int getTotalWinMoney, int money) {
		NumberFormat formatter = new DecimalFormat(NUMBER_FORMAT_PATTERN);
		formatter.setRoundingMode(RoundingMode.DOWN);
		return formatter.format((double)(getTotalWinMoney) / (double)(money));
	}
}
