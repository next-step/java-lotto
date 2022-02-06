package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    THREE(3, 0, 5000),
    FOUR(4, 0, 50000),
    FIVE(5, 0, 1500000),
    FIVEWITHBONUS(5, 1, 30000000),
    SIX(6, 0, 2000000000),
    OTHERS(0, 0, 0);

    private final int numberOfMatches;
    private final int currency;
    private int bonus = 0;
    private int count;

    Ranking(final int numberOfMatches, int bonus, final int currency) {
        this.numberOfMatches = numberOfMatches;
        if (numberOfMatches == 5) {
            this.bonus = bonus;
        }
        this.currency = currency;
    }

    public static Ranking of(final int numberOfMatches, final int bonus) {
        return Arrays.stream(values())
            .filter(
                Ranking -> (Ranking.numberOfMatches == numberOfMatches) &&
                    (Ranking.bonus == bonus))
            .findAny()
            .orElse(OTHERS);
    }

    public int operate(final int count) {
        this.count = count;
        return currency * count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("%d개 일치");
        if (bonus == 1) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append("(%d원) - %d개");
        return String.format(sb.toString(), numberOfMatches, currency, count);
    }
}
