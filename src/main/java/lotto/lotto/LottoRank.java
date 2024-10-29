package lotto.lotto;

import java.util.Arrays;
import java.util.Map;

public enum LottoRank {
    RANK_ONE(6, 2_000_000_000, (matchingCnt, bonusMatch) -> {
        return matchingCnt == 6;
    }),
    RANK_TWO_BONUS(5, 30_000_000, (matchingCnt, bonusMatch) -> {
        return bonusMatch && matchingCnt == 5;
    }),

    RANK_TWO(5, 1_500_000, (matchingCnt, bonusMatch) -> {
        return !bonusMatch && matchingCnt == 5;
    }),
    RANK_THREE(4, 50_000, (matchingCnt, bonusMatch) -> {
        return matchingCnt == 4;
    }),
    RANK_FOUR(3, 5_000, (matchingCnt, bonusMatch) -> {
        return matchingCnt == 3;
    });

    private final int machingCnt;
    private final long winPrice;
    private final RankOperation rankOperation;

    LottoRank(final int machingCnt, final long winPrice, RankOperation rankOperation) {
        this.machingCnt = machingCnt;
        this.winPrice = winPrice;
        this.rankOperation = rankOperation;
    }

    public static double calculateMarginRate(long price, Map<LottoRank, Integer> resultMap) {
        return Arrays.stream(LottoRank.values()).mapToLong(value -> value.winPrice * resultMap.getOrDefault(value, 0)).sum() / (double) price;
    }

    public int getMachingCnt() {
        return machingCnt;
    }

    public long getWinPrice() {
        return winPrice;
    }

    public static LottoRank findWinPrice(int machingCnt, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values()).filter(lottoRank -> lottoRank.getMachingCnt() == machingCnt)
                .filter(lottoRank -> lottoRank.rankOperation.isRank(machingCnt, bonusMatch)).findFirst().orElse(null);
    }
}
