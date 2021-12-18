package lotto.domain;


import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public enum LottoRank {

    FIRST(6, 2_000_000_000, (countOfMatch, matchesBonus) -> countOfMatch == 6),
    SECOND(5, 30_000_000, (countOfMatch, matchesBonus) -> countOfMatch == 5 && matchesBonus),
    THIRD(5, 1_500_000, (countOfMatch, matchesBonus) -> countOfMatch == 5 && !matchesBonus),
    FOURTH(4, 50_000, (countOfMatch, matchesBonus) -> countOfMatch == 4),
    FIFTH(3, 5_000, (countOfMatch, matchesBonus) -> countOfMatch == 3),
    MISS(0, 0, (countOfMatch, matchesBonus) -> countOfMatch <= 2 && countOfMatch >= 0);

    private static final List<LottoRank> lottoRanks = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, MISS);
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
        return lottoRanks.stream()
                .filter(r -> r.matches(countOfMatch, matchBonus))
                .collect(collectingAndThen(
                        Collectors.toList(),
                        list -> list.get(0)));
    }

    public static List<LottoRank> lottoRanks() {
        return Collections.unmodifiableList(lottoRanks);
    }

    private static void validateCountOfMatch(int countOfMatch) {
        if (countOfMatch < 0 || countOfMatch > 6) {
            throw new LottoException("일치 개수는 0개에서 6개 사이만 가능합니다.");
        }
    }

    private boolean matches(int countOfMatch, boolean matchBonus) {
        return rankMatchOperation.apply(countOfMatch, matchBonus);
    }

    public int winningPrize() {
        return this.winningPrize;
    }

    @FunctionalInterface
    interface RankMatchOperation {
        boolean apply(int countOfMatch, boolean matchBonus);
    }

}