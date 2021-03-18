package study.lotto.domain.type;

import java.util.Arrays;

public enum ProfitMessage {

    PROFIT("이익"),
    LOSS("손해"),
    BREAK_POINT("본전");

    private final String msg;

    ProfitMessage(final String msg) {
        this.msg = msg;
    }

    public static ProfitMessage of(final double rate) {
        return Arrays.stream(ProfitMessage.values())
                .map(profitMessage -> matchMessage(rate))
                .findAny()
                .orElse(BREAK_POINT);
    }

    private static ProfitMessage matchMessage(final double rate) {
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
