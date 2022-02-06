package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    Three(3, 0, 5000),
    Four(4, 0, 50000),
    Five(5, 0, 1500000),
    FiveWithBonus(5, 1, 30000000),
    Six(6, 0, 2000000000),
    OTHERS(0, 0, 0);

    private final int numberOfWinningNumbers;
    private final int currency;
    private int bonus = 0;
    private int count;

    Ranking(final int numberOfWinningNumbers, int bonus, final int currency) {
        this.numberOfWinningNumbers = numberOfWinningNumbers;
        if (numberOfWinningNumbers == 5) {
            this.bonus = bonus;
        }
        this.currency = currency;
    }

    public static Ranking of(final int numberOfWinningNumbers, final int bonus) {
        return Arrays.stream(values())
            .filter(
                Ranking -> (Ranking.numberOfWinningNumbers == numberOfWinningNumbers) &&
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
        return String.format(sb.toString(), numberOfWinningNumbers, currency, count);
    }
}
