package lotto.step3.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private static final String RATE_PATTERN = "0.##";

    public static Map<Rank, Integer> createLottoStatistics(WinningLotto winningLotto, Lotteries lotteries) {
        Map<Rank, Integer> lottoStatistics = new HashMap<>();
        for (Lotto lotto : lotteries.getLotteries()) {
            Rank rank = Rank.rank(lotto.countOfMatch(winningLotto.getWinningNumbers()), lotto.contains(winningLotto.getBonusBall()));
            lottoStatistics.put(rank, lottoStatistics.getOrDefault(rank, 0) + 1);
        }
        return lottoStatistics;
    }

    public static double calculateRateOfProfit(Map<Rank, Integer> lottoStatistics, OrderPrice orderPrice) {
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(format.format(totalPrizeMoney(lottoStatistics) / orderPrice.getOrderPrice()));
    }

    private static double totalPrizeMoney(Map<Rank, Integer> lottoStatistics) {
        return lottoStatistics.keySet().stream()
                .mapToInt(rank -> rank.getPrizeMoney() * lottoStatistics.get(rank))
                .sum();
    }

}
