package lotto.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class Profit {

    public static final String PATTERN = "0.00";
    public static final int SCALE_NUMBER = 2;

    private WinningResult winningResult;

    public Profit(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public int getWinningAmount() {
        int winningAmount = NUMBER_ZERO;

        for (Rank rank : Rank.values()) {
            long winningNumber = this.winningResult.getWinningResult(rank);
            winningAmount += winningNumber * rank.getWinningMoney();
        }
        return winningAmount;
    }

    public String getRateOfReturn(int paymentAmount, int winningMoney) {
        String number = toString(paymentAmount, winningMoney);
        BigDecimal bigDecimal = new BigDecimal(number).setScale(SCALE_NUMBER, BigDecimal.ROUND_FLOOR);
        String reteOfReturn = new DecimalFormat(PATTERN).format(bigDecimal);
        return reteOfReturn;
    }

    public String toString(int paymentAmount, int winningMoney) {
        double lottoPaymentPrice = toDouble(paymentAmount);
        double lottoWinningMoney = toDouble(winningMoney);
        double profit = lottoWinningMoney / lottoPaymentPrice;
        return String.valueOf(profit);
    }

    private double toDouble(int value) {
        String number = String.valueOf(value);
        return Double.parseDouble(number);
    }

    public double getBaseValue(String profitValue) {
        return Double.parseDouble(profitValue);
    }
}
