package camp.nextstep.edu.nextstep8.lotto;

import java.util.Arrays;

public enum LottoAward {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int condition;
    private int prize;

    LottoAward(int condition, int prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public int getCondition() {
        return condition;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoAward of (int condition) {
        return Arrays.stream(values())
                .filter(e -> e.getCondition() == condition)
                .findFirst()
                .orElse(null);
    }
}
