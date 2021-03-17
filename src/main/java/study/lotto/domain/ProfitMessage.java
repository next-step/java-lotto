package study.lotto.domain;

import java.util.Arrays;

public enum ProfitMessage {

    PROFIT("이익"),
    LOSS("손해"),
    BREAK_POINT("본전");

    private final String msg;

    ProfitMessage(String msg) {
        this.msg = msg;
    }

    public static ProfitMessage of(double rate) {
        return Arrays.stream(ProfitMessage.values())
                .map(profitMessage -> matchMessage(rate))
                .findAny()
                .orElse(BREAK_POINT);
    }

    private static ProfitMessage matchMessage(double rate) {
        if(rate > 1) {
            return PROFIT;
        }
        if(rate < 1) {
            return LOSS;
        }
        return BREAK_POINT;
    }

    @Override
    public String toString() {
        return msg;
    }
}
