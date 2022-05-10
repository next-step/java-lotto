package lotto.constant;

import lotto.domain.LottoNumbers;
import lotto.exception.InvalidMatchCount;

import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int SECOND_OR_THIRD = 5;

    private final int matchCount;
    private final int winPrice;

    Rank(int matchCount, int winPrice) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount > LottoNumbers.LOTTO_NUMBER_COUNT) {
            throw new InvalidMatchCount();
        }
        if (isSecondOrThirdRank(matchCount)) {
            return secondOrThird(matchBonus);
        }
        return Stream.of(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    private static boolean isSecondOrThirdRank(int matchCount) {
        return matchCount == SECOND_OR_THIRD;
    }

    private static Rank secondOrThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int winPrice() {
        return this.winPrice;
    }
}
