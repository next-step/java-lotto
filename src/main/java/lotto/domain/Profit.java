package lotto.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class Profit {

    private static final String PATTERN = "0.00";
    private static final int SCALE_NUMBER = 2;

    private WinningResult winningResult;

    public Profit(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public int getWinningAmount() {
        int winningAmount = NUMBER_ZERO;

        for (Rank rank : Rank.values()) {
            long winningNumber = winningResult.getWinningResult(rank);
            winningAmount += winningNumber * rank.getWinningMoney();
        }
        return winningAmount;
    }

    public String getRateOfReturn(int paymentAmount, int winningMoney) {
        String number = toString(paymentAmount, winningMoney);
        BigDecimal bigDecimal = new BigDecimal(number).setScale(SCALE_NUMBER, BigDecimal.ROUND_FLOOR);
        return new DecimalFormat(PATTERN).format(bigDecimal);
    }

    public String toString(int paymentAmount, int winningMoney) {
        double lottoPaymentPrice = toDouble(paymentAmount);
        double lottoWinningMoney = toDouble(winningMoney);
        return toString(getProfit(lottoPaymentPrice, lottoWinningMoney));
    }

    private double getProfit(double lottoPaymentPrice, double lottoWinningMoney) {
        return lottoWinningMoney / lottoPaymentPrice;
    }

    private double toDouble(int value) {
        String number = String.valueOf(value);
        return Double.parseDouble(number);
    }

    private String toString(double value) {
        return String.valueOf(value);
    }

    public double getBaseValue(String profitValue) {
        return Double.parseDouble(profitValue);
    }
}
