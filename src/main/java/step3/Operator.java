package step3;

import java.util.Arrays;

public enum Operator {
    NOT_RANK(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int count;
    private final int winning;

    Operator(int count, int winning) {
        this.count = count;
        this.winning = winning;
    }

    public static Operator find(int count, boolean bonus) {
        if (count == FIVE.count && bonus) {
            return FIVE_BONUS;
        }
        return Arrays.stream(values())
                .filter(ranks -> ranks.count == count)
                .findFirst()
                .orElse(NOT_RANK);
    }

    public int getCount() {
        return count;
    }

    public int getWinning() {
        return winning;
    }
}
