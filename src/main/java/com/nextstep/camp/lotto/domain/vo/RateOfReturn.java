package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.lotto.domain.type.ProfitType;

public class RateOfReturn {
    private final double rate;
    private final ProfitType profitType;

    private RateOfReturn(int totalPrize, LottoAmount spent) {
        this.rate = (double) totalPrize / spent.getValue();
        this.profitType = ProfitType.fromRate(rate);
    }

    public static RateOfReturn of(int totalPrize, LottoAmount spent) {
        return new RateOfReturn(totalPrize, spent);
    }

    public ProfitType getProfitType() {
        return profitType;
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }
}
