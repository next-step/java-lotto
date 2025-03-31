package com.nextstep.camp.lotto.domain.vo;

public class RateOfReturn {
    private final double rate;

    private RateOfReturn(int totalPrize, Money spent) {
        this.rate = (double) totalPrize / spent.getValue();
    }

    public static RateOfReturn of(int totalPrize, Money spent) {
        return new RateOfReturn(totalPrize, spent);
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }
}
