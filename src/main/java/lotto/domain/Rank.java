package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 3_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonusMatch;

    private Rank(int countOfMatch, int winningMoney, boolean bonusMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public static Rank getRankByMatchCount(int countOfMatch, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> {
                    // 보너스 매치가 필요한 경우와 아닌 경우를 구분
                    if (rank == SECOND) {
                        return bonusMatch; // SECOND는 보너스 매치가 true여야 함
                    }
                    return rank != SECOND || !bonusMatch; // 나머지는 보너스 매치와 무관
                })
                .findFirst()
                .orElse(MISS);
    }
}
