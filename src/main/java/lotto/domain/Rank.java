package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_VALUE_MSG = "값이 잘못되었습니다. 다시 한번 확인해주세요.";

    private int hitNum, money;

    Rank(int hitNum, int money) {
        this.hitNum = hitNum;
        this.money = money;
    }

    public int getHitNum() {
        return hitNum;
    }

    public int getMoney() {
        return money;
    }

    public static Rank converterPrize(int matchCount) {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.matchCountToRank(matchCount))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_VALUE_MSG));
    }

    private Rank matchCountToRank(int matchCount) {
        if (matchCount < WINNING_MIN_COUNT) {
            return MISS;
        }
        if (getHitNum() == matchCount) {
            return this;
        }
        return null;
    }
}
