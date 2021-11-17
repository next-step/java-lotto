package lotto.step2.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Profit {

    private static final String RATE_PATTERN = "0.##";
    private static final int LOTTO_SIZE = 6;

    private final Lotteries lotteries;
    private final Lotto winningNumbers;
    private final int orderPrice;

    public Profit(Lotteries lotteries, Lotto winningNumbers,  int orderPrice) {
        this.lotteries = lotteries;
        this.winningNumbers = winningNumbers;
        this.orderPrice = orderPrice;
    }

    public double calculateRateOfProfit() {
        double totalPrizeMoney = 0;
        for (int count = LOTTO_SIZE - 3; count <= LOTTO_SIZE; count++) {
            int totalCountOfMatch = lotteries.totalCountOfMatch(winningNumbers, count);
            totalPrizeMoney += Rank.valueOf(count).getPrizeMoney() * totalCountOfMatch;
        }
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
    }

}
