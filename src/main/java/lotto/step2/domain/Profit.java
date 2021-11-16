package lotto.step2.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Profit {

    private static final String RATE_PATTERN = "0.##";
    private static final int LOTTO_SIZE = 6;

    private final Statics statics;
    private final int orderPrice;
    private double rateOfProfit;

    public Profit(Statics statics, int orderPrice) {
        this.statics = statics;
        this.orderPrice = orderPrice;
        calculateRateOfProfit();
    }

    public double getRateOfProfit() {
        return rateOfProfit;
    }

    private void calculateRateOfProfit() {
        double totalPrizeMoney = 0;
        for (int count = LOTTO_SIZE - 3; count <= LOTTO_SIZE; count++) {
            int totalCountOfMatch = statics.totalCountOfMatch(count);
            totalPrizeMoney += Rank.valueOf(count).getPrizeMoney() * totalCountOfMatch;
        }
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        rateOfProfit = Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
    }

}
