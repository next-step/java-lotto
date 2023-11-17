package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean isBonus;

    LottoRank(int matchCount, int prizeAmount, boolean isBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.isBonus = isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public static LottoRank of(long countOfMatch, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> filterLottoRank(lottoRank, countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean filterLottoRank(LottoRank lottoRank, long countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.getMatchCount()) {
            return lottoRank.getMatchCount() == countOfMatch && lottoRank.isBonus() == matchBonus;
        }
        return lottoRank.getMatchCount() == countOfMatch;
    }

    public static int prizeAmount(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount && lottoRank.isBonus() == matchBonus)
                .map(LottoRank::getPrizeAmount)
                .findFirst()
                .orElse(MISS.prizeAmount);
    }
}
