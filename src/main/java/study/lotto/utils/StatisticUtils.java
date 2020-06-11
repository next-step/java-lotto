package study.lotto.utils;

import study.lotto.domain.LottoRank;
import study.lotto.domain.LottoResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class StatisticUtils {

    private StatisticUtils() {}

    public static BigDecimal calculateEarningRate(int totalPrice, LottoResult lottoResult) {
        BigDecimal totalEarning = new BigDecimal(calculateTotalEarning(lottoResult.getRankToCount()));

        return totalEarning.divide(new BigDecimal(totalPrice), 10, RoundingMode.HALF_EVEN);
    }

    private static int calculateTotalEarning(Map<LottoRank, Integer> rankToCount) {
        return rankToCount.keySet()
                .stream()
                .map(lottoRank -> lottoRank.getPrize() * rankToCount.get(lottoRank))
                .mapToInt(Integer::intValue).sum();
    }
}
