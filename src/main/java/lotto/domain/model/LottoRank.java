package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FAIL(0, false, new Money(0)),
    FIFTH(3, false, new Money(5_000)),
    FOURTH(4, false, new Money(50_000)),
    THIRD(5, false, new Money(1_500_000)),
    SECOND(5, true, new Money(30_000_000)),
    FIRST(6, false, new Money(2_000_000_000));

    private final int numOfMatch;
    private final boolean isBonusMatched;
    private final Money amountOfPrize;

    public static final List<LottoRank> RANK_WITH_PRIZE = Stream.of(values())
            .filter(rank -> rank.getPrize() != 0)
            .collect(Collectors.toList());

    LottoRank(int numOfMatch, boolean isBonusMatched, Money amountOfPrize) {
        this.numOfMatch = numOfMatch;
        this.isBonusMatched = isBonusMatched;
        this.amountOfPrize = amountOfPrize;
    }

    public int getNumOfMatch() {
        return numOfMatch;
    }

    public int getPrize() {
        return amountOfPrize.getAmount();
    }

    public static LottoRank of(int numOfMatch, boolean isBonusMatched) {
        if (numOfMatch < 3) return FAIL;

        if (numOfMatch == 5) {
            return isBonusMatched ? SECOND : THIRD;
        }

        return Stream.of(values())
                .filter(rank -> rank.numOfMatch == numOfMatch)
                .findFirst()
                .orElse(FAIL);
    }
}
