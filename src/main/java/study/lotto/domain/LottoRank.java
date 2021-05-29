package study.lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum LottoRank {
    FIFTH(3, BigDecimal.valueOf(5_000)),
    FOURTH(4, BigDecimal.valueOf(50_000)),
    THIRD(5, BigDecimal.valueOf(1_500_000)),
    SECOND(5, BigDecimal.valueOf(30_000_000)),
    FIRST(6, BigDecimal.valueOf(2_000_000_000));

    private int matchCount;
    private BigDecimal prize;

    LottoRank(int matchCount, BigDecimal prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Optional<LottoRank> of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(winningPrize -> winningPrize.matchCount == matchCount)
                .map(winningPrize -> checkSeconPrize(winningPrize, matchBonus))
                .findFirst();
    }

    private static LottoRank checkSeconPrize(LottoRank lottoRank, boolean matchBonus) {
        if (THIRD.equals(lottoRank) && matchBonus) {
            return SECOND;
        }
        return lottoRank;
    }

    public int matchCount() {
        return matchCount;
    }

    public BigDecimal prize() {
        return prize;
    }

    public static Stream<LottoRank> stream() {
        return Stream.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

}
