package com.nextstep.camp.lotto.domain.vo;

public class RateOfReturn {
    private final double rate;

    public RateOfReturn(int totalPrize, Money spent) {
        this.rate = (double) totalPrize / spent.getValue();
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }
}
