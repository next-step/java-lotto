package lotto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BOOM(0, 0);

    private int matchCount;
    private long price;

    private static final Map<Integer, LottoRank> RANK;

    static {
        RANK = Collections.unmodifiableMap(
                Stream.of(LottoRank.values())
                        .filter(lottoRank -> !lottoRank.equals(LottoRank.SECOND))
                        .collect(Collectors.toMap(LottoRank::getMatchCount, lottoRank -> lottoRank))
        );
    }

    LottoRank(int matchCount, long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }

    public static LottoRank valueOf(int matchCount, boolean isBonusNumberMatch) {
        if (matchCount < FOURTH.matchCount) {
            return BOOM;
        }
        if (matchCount == SECOND.matchCount && isBonusNumberMatch) {
            return SECOND;
        }
        return RANK.get(matchCount);
    }

    public static List<LottoRank> valuesWithOutBoom() {
        return Arrays.stream(values())
                .filter(lottoRank -> !lottoRank.equals(BOOM))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static Map<LottoRank, Long> convertLottoRankWithCount(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .filter(lottoRank -> !lottoRank.equals(BOOM))
                .collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));
    }
}
