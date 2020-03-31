package lotto;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3);

    private int matchCount;

    Rank(int matchCount) {
        this.matchCount = matchCount;
    }


    public int getWinningMoney() {
        return 2000000000;
    }

    public static Rank of(int matchCount) {
        return Stream.of(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 랭킹입니다."));
    }
}
