package study.lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    MISS(0, BigDecimal.ZERO),
    FIFTH(3, BigDecimal.valueOf(5_000)),
    FOURTH(4, BigDecimal.valueOf(50_000)),
    THIRD(5, BigDecimal.valueOf(1_500_000)),
    SECOND(5, BigDecimal.valueOf(30_000_000)),
    FIRST(6, BigDecimal.valueOf(2_000_000_000));

    private final int matchCount;
    private final BigDecimal prize;

    LottoRank(int matchCount, BigDecimal prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {

        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatch(matchCount))
                .map(lottoRank -> checkSeconPrize(lottoRank, matchBonus))
                .findFirst().orElse(MISS);
    }

    private boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
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

    public static List<LottoRank> prizeableRank() {
        return Arrays.stream(values())
                .filter(lottoRank -> !lottoRank.equals(MISS))
                .collect(Collectors.toList());
    }

}
