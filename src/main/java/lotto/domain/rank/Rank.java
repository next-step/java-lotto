package lotto.domain.rank;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    OUT(0, false,  0L),
    SEVENTH(1, false, 0L),
    SIXTH(2, false, 0L),
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L);

    private int matchNumber;
    private boolean bonusMatch;
    private long price;

    Rank(int matchNumber, boolean bonusMatch, long price) {
        this.matchNumber = matchNumber;
        this.bonusMatch = bonusMatch;
        this.price = price;
    }

    public static boolean canGetPrize(Rank inputRank) {
        return inputRank.getPrice() > 0L;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public long getPrice() {
        return price;
    }

    public static Rank create(int matchNumber, boolean bonusMatch) {
        Optional<Rank> candidateRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNumber == matchNumber && rank.bonusMatch == bonusMatch)
                .findFirst();
        return candidateRank.orElseThrow(IllegalArgumentException::new);
    }
}
