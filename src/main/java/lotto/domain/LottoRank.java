package lotto.domain;


import lotto.exception.LottoException;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000, (countOfMatch, matchesBonus) -> countOfMatch == 6),
    SECOND(5, 30_000_000, (countOfMatch, matchesBonus) -> countOfMatch == 5 && matchesBonus),
    THIRD(5, 1_500_000, (countOfMatch, matchesBonus) -> countOfMatch == 5 && !matchesBonus),
    FOURTH(4, 50_000, (countOfMatch, matchesBonus) -> countOfMatch == 4),
    FIFTH(3, 5_000, (countOfMatch, matchesBonus) -> countOfMatch == 3),
    MISS(0, 0, (countOfMatch, matchesBonus) -> countOfMatch <= 2 && countOfMatch >= 0);

    public static final int MAX_COUNT_OF_MATCH = 6;
    public static final int MIN_COUNT_OF_MATCH = 0;
    private final int countOfMatch;
    private final int winningPrize;
    private final RankMatchOperation rankMatchOperation;

    LottoRank(int countOfMatch, int winningPrize, RankMatchOperation rankMatchOperation) {
        this.countOfMatch = countOfMatch;
        this.winningPrize = winningPrize;
        this.rankMatchOperation = rankMatchOperation;

    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        validateCountOfMatch(countOfMatch);
        return Arrays.stream(values())
                .filter(r -> r.matches(countOfMatch, matchBonus))
                .findFirst()
                .orElseThrow(() -> new LottoException("매칭되는 Rank가 없습니다"));

    }

    private static void validateCountOfMatch(int countOfMatch) {
        if (countOfMatch < MIN_COUNT_OF_MATCH || countOfMatch > MAX_COUNT_OF_MATCH) {
            throw new LottoException("일치 개수는 " + MIN_COUNT_OF_MATCH + "개에서 " + MAX_COUNT_OF_MATCH + "개 사이만 가능합니다.");
        }
    }

    private boolean matches(int countOfMatch, boolean matchBonus) {
        return rankMatchOperation.apply(countOfMatch, matchBonus);
    }

    public int countOfMatch() {
        return this.countOfMatch;
    }

    public int winningPrize() {
        return this.winningPrize;
    }

    @FunctionalInterface
    interface RankMatchOperation {
        boolean apply(int countOfMatch, boolean matchBonus);
    }

}