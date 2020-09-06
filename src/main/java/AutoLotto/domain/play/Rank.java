package AutoLotto.domain.play;

import java.util.Arrays;
import java.util.List;

import static AutoLotto.utils.Constants.*;

public enum Rank {
    FIRST(MATCH_COUNT_FIRST, RANK_MONEY_FIRST),
    SECOND(MATCH_COUNT_SECOND,RANK_MONEY_SECOND),
    THIRD(MATCH_COUNT_THIRD, RANK_MONEY_THIRD),
    FOURTH(MATCH_COUNT_FOURTH, RANK_MONEY_FOURTH),
    FIFTH(MATCH_COUNT_FIFTH, ZERO_MONEY_FIFTH),
    SIXTH(MATCH_COUNT_SIXTH, ZERO_MONEY_SIXTH),
    NO_MATCH(MATCH_COUNT_NO_MATCH, ZERO_MONEY_NO_MATCH);

    public final int matchCount;
    public final int rankMoney;

    Rank(int matchCount, int rankMoney){
        this.matchCount = matchCount;
        this.rankMoney = rankMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRankMoney() {
        return rankMoney;
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

    public static int createBuzzMoney(List<Integer> matchCountList) {
        return matchCountList.stream()
                .map(matchCount -> Rank.matchOf(matchCount))
                .mapToInt(rank -> rank.getRankMoney())
                .sum();
    }
}
