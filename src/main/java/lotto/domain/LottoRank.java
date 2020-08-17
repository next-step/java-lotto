package lotto.domain;

import java.util.Comparator;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    DROP(0, 0);

    private int matchCount;
    private int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount) {
        return LottoRank.stream()
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.DROP);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Stream<LottoRank> stream() {
        return Stream.of(LottoRank.values())
                .sorted(Comparator.comparingInt(rank -> rank.matchCount));
    }

}
