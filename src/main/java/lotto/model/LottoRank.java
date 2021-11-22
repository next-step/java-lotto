package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int amount;

    LottoRank(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static LottoRank valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(r -> matchCount == r.matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static List<LottoRank> valuesWithoutMiss() {
        List<LottoRank> ranksWithoutMiss = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.MISS)
                .collect(Collectors.toList());
        Collections.reverse(ranksWithoutMiss);
        return ranksWithoutMiss;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }
}