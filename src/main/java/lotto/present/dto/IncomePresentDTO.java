package lotto.present.dto;

import lotto.domain.Winners;

public class IncomePresentDTO {
    private final double profitRatio;
    private final String breakEvenMessage;
    public IncomePresentDTO(Winners winners) {
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
