package com.nextstep.camp.lotto.domain.vo;

public class RateOfReturn {
    private final double rate;

    private RateOfReturn(int totalPrize, LottoAmount spent) {
        this.rate = (double) totalPrize / spent.getValue();
    }

    public static RateOfReturn of(int totalPrize, LottoAmount spent) {
        return new RateOfReturn(totalPrize, spent);
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }
}
