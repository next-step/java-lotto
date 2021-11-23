package lotto.model;

import common.model.Number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int amount;

    LottoRank(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static LottoRank valueOf(Number matchCount) {
        return Arrays.stream(values())
                .filter(r -> matchCount.equals(new Number(r.matchCount)))
                .findFirst()
                .orElse(MISS);

    }

    public static LottoRank valueOf(Number matchCount, boolean isBonus) {
        if (matchCount.equals(new Number(5))) {
            return secondOrThird(isBonus);
        }
        return valueOf(matchCount);
    }

    private static LottoRank secondOrThird(boolean isBonus) {
        if (isBonus) {
            return SECOND;
        }
        return THIRD;
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