package lottery_bonus.type;

import java.util.Arrays;

public enum ProfitRateMessage {
    LOSS(-1, "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
    BENEFIT(1, "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)"),
    BREAK_EVEN(0, "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");

    private final int criteria;
    private final String message;

    ProfitRateMessage(int criteria, String message) {
        this.criteria = criteria;
        this.message = message;
    }

    public static ProfitRateMessage equal(int criteria){
        return Arrays.asList(ProfitRateMessage.values())
                .stream()
                .filter(profitRateMessage -> profitRateMessage.criteria == criteria)
                .findAny().get();
    }

    public String getMessage() {
        return message;
    }


}
