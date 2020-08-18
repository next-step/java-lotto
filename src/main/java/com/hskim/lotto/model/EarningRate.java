package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EarningRate {
    public static final double STANDARD_RATE = 1.0;
    public static final int RESULT_VALUE_SCALE = 2;

    private String earningRate;
    private boolean isProfit;

    public EarningRate(BigDecimal income, BigDecimal expense) {
        validateExpense(expense);
        this.earningRate = income.divide(expense, RESULT_VALUE_SCALE, RoundingMode.HALF_UP).toString();
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

    public String getEarningRate() {
        return earningRate;
    }

    public boolean isProfit() {
        return isProfit;
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
