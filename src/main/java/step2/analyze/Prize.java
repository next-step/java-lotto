package step2.analyze;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {
    KRW_0_000(0, false, 0),
    KRW_5_000(3, false, 5_000),
    KRW_50_000(4, false, 50_000),
    KRW_1_500_000(5, false, 1_5000_000),
    KRW_30_000_000(5, true, 30_000_000),
    KRW_2_000_000_000(6, false, 2_000_000_000);

    public static final int MAX_MATCH_COUNT = 6;

    private final int matchCount;
    private final boolean bonus;
    private final int money;

    Prize(int matchCount, boolean bonus, int money) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.money = money;
    }

    public static Prize of(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> prize.matchCount != (MAX_MATCH_COUNT - 1) || prize.bonus == bonus)
                .findFirst()
                .orElse(Optional.of(KRW_0_000).get());
    }

    public int calculateEarningMoney(int lottoGameCount) {
        return this.money * lottoGameCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getMoney() {
        return money;
    }
}
