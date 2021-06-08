package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, (matchCount, isBonusMatch) -> matchCount == 6, "6개 일치"),
    SECOND(30000000, (matchCount, isBonusMatch) -> matchCount == 5 && isBonusMatch, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, (matchCount, isBonusMatch) -> matchCount == 5, "5개 일치"),
    FOURTH(50000, (matchCount, isBonusMatch) -> matchCount == 4, "4개 일치"),
    FIFTH(5000, (matchCount, isBonusMatch) -> matchCount == 3, "3개 일치"),
    MISS(0, (matchCount, isBonusMatch) -> false, "꽝");

    private int money;
    private WinningStrategy condition;
    private String message;

    Rank(int money, WinningStrategy condition, String message) {
        this.money = money;
        this.condition = condition;
        this.message = message;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public static Rank getRank(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.winning(matchCount, isBonusMatch))
                .findFirst()
                .orElse(MISS);
    }

}
