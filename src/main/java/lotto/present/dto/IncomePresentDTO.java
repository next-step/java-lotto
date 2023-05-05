package lotto.present.dto;

import lotto.domain.Statics;

public class IncomePresentDTO {
    private final double profitRatio;
    private final String breakEvenMessage;

    public IncomePresentDTO(Statics statics) {
        this.profitRatio = statics.profitRatio();
        this.breakEvenMessage = statics.breakEvenMessage();
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public String getBreakEvenMessage() {
        return breakEvenMessage;
    }
}
