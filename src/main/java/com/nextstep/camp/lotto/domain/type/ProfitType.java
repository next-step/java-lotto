package com.nextstep.camp.lotto.domain.type;

public enum ProfitType {
    PROFIT("이득"),
    LOSS("손해"),
    BREAK_EVEN("본전");

    private final String description;

    ProfitType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ProfitType fromRate(double rate) {
        if (rate > 1.0) {
            return PROFIT;
        }
        if (rate < 1.0) {
            return LOSS;
        }
        return BREAK_EVEN;
    }
}
