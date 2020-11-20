package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final boolean matchedBonus;
    private int matchedCount;
    private int winningMoney;

    LottoRanking(int matchedCount, int winningMoney){
        this(matchedCount, winningMoney, false);
    }

    LottoRanking(int matchedCount, int winningMoney, boolean matchedBonus ) {
        this.matchedCount = matchedCount;
        this.winningMoney = winningMoney;
        this.matchedBonus = matchedBonus;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRanking valueOf(Lotto lotto, WinningNumber winningNumber){
        long matchedCount = winningNumber.getMatchedWinningNumberCount(lotto);
        boolean matchedBonus = winningNumber.matchBonusNumber(lotto);

        return Arrays.stream(LottoRanking.values())
                .filter(it -> it.matchedCount == matchedCount && it.matchedBonus == matchedBonus)
                .findFirst().orElse(MISS);
    }
}
