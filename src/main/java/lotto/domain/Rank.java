package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final String ERROR_MESSAGE = "일치하는 등수가 없습니다.";
    private final long countOfMatch;
    private final boolean bonusMatch;
    private final long winningMoney;

    Rank(long countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatch = false;
        this.winningMoney = winningMoney;

    }

    Rank(long countOfMatch, boolean bonusMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(long matchCount, boolean bonus) {
        if (matchCount == 5) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> rank.countOfMatch == matchCount && rank.bonusMatch == bonus)
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == matchCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }

    public static Rank valueOf(int ordinalNum) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getOrdinal() == ordinalNum)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }


    public int getOrdinal() {
        return ordinal();
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public String isBonusMatch() {
        if (bonusMatch)
            return ", 보너스 볼 일치";
        return " ";
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
