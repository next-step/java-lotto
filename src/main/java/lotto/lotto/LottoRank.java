package lotto.lotto;

import java.util.Arrays;
import java.util.Map;

public enum LottoRank {
    RANK_ONE(6, 2_000_000_000),
    RANK_TWO_BONUS(5, 30_000_000),
    RANK_TWO(5, 1_500_000),
    RANK_THREE(4, 50_000),
    RANK_FOUR(3, 5_000);

    private final int machingCnt;
    private final long winPrice;

    LottoRank(final int machingCnt, final long winPrice) {
        this.machingCnt = machingCnt;
        this.winPrice = winPrice;
    }

    public static double calculateMarginRate(long price, Map<LottoRank, Integer> resultMap) {
        return Arrays.stream(LottoRank.values()).mapToLong(value -> value.winPrice * resultMap.getOrDefault(value,0)).sum() / (double) price;
    }

    public int getMachingCnt() {
        return machingCnt;
    }

    public long getWinPrice() {
        return winPrice;
    }

    public static LottoRank findWinPrice(int machingCnt, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values()).filter(lottoRank -> lottoRank.getMachingCnt() == machingCnt)
                .map(lottoRank -> {
                    LottoRank rankTwoBonus = checkRankTwoAndBonus(machingCnt, bonusMatch);
                    if (rankTwoBonus != null) {
                        return rankTwoBonus;
                    }
                    return lottoRank;
                }).findFirst().orElse(null);
    }

    private static LottoRank checkRankTwoAndBonus(int machingCnt, boolean bonusMatch) {
        if (bonusMatch && machingCnt == LottoRank.RANK_TWO_BONUS.getMachingCnt()) {
            return LottoRank.RANK_TWO_BONUS;
        }

        if (!bonusMatch && machingCnt == LottoRank.RANK_TWO_BONUS.getMachingCnt()) {
            return LottoRank.RANK_TWO;
        }
        return null;
    }

}
