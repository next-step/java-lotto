package AutoLotto.domain.play;

import java.util.Arrays;

import static AutoLotto.utils.Constants.*;

public enum Rank {
    NO_MATCH(MATCH_COUNT_NO_MATCH, ZERO_MONEY_NO_MATCH),
    SIXTH(MATCH_COUNT_SIXTH, ZERO_MONEY_SIXTH),
    FIFTH(MATCH_COUNT_FIFTH, ZERO_MONEY_FIFTH),
    FOURTH(MATCH_COUNT_FOURTH, RANK_MONEY_FOURTH),
    THIRD(MATCH_COUNT_THIRD, RANK_MONEY_THIRD),
    SECOND(MATCH_COUNT_SECOND, RANK_MONEY_SECOND),
    FIRST(MATCH_COUNT_FIRST, RANK_MONEY_FIRST);

    public final int matchCount;
    public final int rankMoney;

    Rank(int matchCount, int rankMoney) {
        this.matchCount = matchCount;
        this.rankMoney = rankMoney;
    }

    public static Rank matchOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

}
