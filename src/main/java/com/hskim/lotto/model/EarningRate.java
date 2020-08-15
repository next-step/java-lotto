package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EarningRate {
    private static final double STANDARD_RATE = 1.0;
    private static final String LOSS_ALERT_MESSAGE = "(기준이" + STANDARD_RATE + "이기 때문에 결과적으로 손해라는 의미임)";

    private String earningRate;
    private boolean isProfit;

    public EarningRate(BigDecimal income, BigDecimal expense) {
        validateExpense(expense);
        this.earningRate = income.divide(expense, 2, RoundingMode.HALF_UP).toString();
        setProfit();
    }

    private void validateExpense(BigDecimal expense) {
        if (expense.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException();
        }
    }

    private void setProfit() {
        isProfit = Double.parseDouble(earningRate) > STANDARD_RATE;
    }

    public String makeEarningRateString() {
        String result = "총 수익률은 "
                + earningRate
                + "입니다.";

        if (isProfit) {
            return result;
        }

        return result + LOSS_ALERT_MESSAGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EarningRate)) return false;
        EarningRate that = (EarningRate) o;
        return isProfit == that.isProfit &&
                Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate, isProfit);
    }
}
