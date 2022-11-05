package lotto.constant;

import java.util.Arrays;

public enum LottoRanking {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int ranking;
    private final int award;

    LottoRanking(int ranking, int award) {
        this.ranking = ranking;
        this.award = award;
    }

    public static LottoRanking of(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRanking.values())
                .filter(value -> value.ranking == matchCount)
                .filter(lottoRank -> lottoRank.checkBonusMatch(matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getAward() {
        return award;
    }

    public int getRanking() {
        return ranking;
    }

    private boolean checkBonusMatch(boolean bonusMatch) {
        if (this == SECOND) {
            return bonusMatch;
        }

        if (this == THIRD) {
            return !bonusMatch;
        }

        return true;
    }

    public double calculateAward(int count) {
        return (double) award * count;
    }
}

