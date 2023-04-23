package lotto.present.vo;

import lotto.domain.Winners;

public class IncomePresentVO {
    private final double profitRatio;
    private final String breakEvenMessage;
    public IncomePresentVO(Winners winners) {
        this.profitRatio = winners.getProfitRatio();
        this.breakEvenMessage = winners.breakEvenMessage();
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public String getBreakEvenMessage() {
        return breakEvenMessage;
    }
}
