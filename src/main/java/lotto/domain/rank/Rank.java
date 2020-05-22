package lotto.domain.rank;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    OUT_ALL(0, 0L),
    ONLY_BONUS(0,0L),
    SEVENTH(1, 0L),
    SIXTH(2, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private int matchNumber;
    private long price;

    Rank(int matchNumber, long price) {
        this.matchNumber = matchNumber;
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
                .filter(rank -> rank.matchNumber == matchNumber)
                .findFirst();

        if (matchNumber == 5 && bonusMatch) {
            return SECOND;
        }

        return candidateRank.orElseThrow(IllegalArgumentException::new);
    }
}
