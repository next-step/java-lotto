package com.seok2.lotto.domain.common;

import java.math.BigDecimal;
import java.util.Objects;

public class ReturnOnInvestmentRate {

    private BigDecimal returnOnInvestmentRate;

    private ReturnOnInvestmentRate(BigDecimal returnOnInvestmentRate) {
        this.returnOnInvestmentRate = returnOnInvestmentRate;
    }

    public static ReturnOnInvestmentRate of(double returnOnInvestmentRate) {
        return of(BigDecimal.valueOf(returnOnInvestmentRate));
    }

    public static ReturnOnInvestmentRate of(BigDecimal returnOnInvestmentRate) {
        return new ReturnOnInvestmentRate(returnOnInvestmentRate);
    }

    @Override
    public String toString() {
        return returnOnInvestmentRate.toPlainString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReturnOnInvestmentRate that = (ReturnOnInvestmentRate) o;
        return Objects.equals(returnOnInvestmentRate, that.returnOnInvestmentRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnOnInvestmentRate);
    }
}
