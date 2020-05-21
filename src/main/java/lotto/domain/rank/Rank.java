package lotto.domain.rank;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    OUT(0, 0L),
    SIXTH(1, 0L),
    FIFTH(2, 0L),
    FOURTH(3, 5000L),
    THIRD(4, 50000L),
    SECOND(5, 1500000L),
    FIRST(6, 2000000000L);

    private int matchNumber;
    private long price;

    Rank(int matchNumber, long price) {
        this.matchNumber = matchNumber;
        this.price = price;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public long getPrice() {
        return price;
    }

    public static Rank create(int matchNumber) {
        Optional<Rank> candidateRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchNumber() == matchNumber)
                .findFirst();
        return candidateRank.orElseThrow(IllegalArgumentException::new);
    }
}
