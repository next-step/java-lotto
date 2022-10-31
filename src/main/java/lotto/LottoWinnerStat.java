package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinnerStat {
    private final Map<LottoWinnerClass, Long> map;
    private final int ticketCount;

    public LottoWinnerStat(int ticketCount, List<LottoWinner> winners) {
        this.ticketCount = ticketCount;
        this.map = winners.stream()
                .collect(Collectors.groupingBy(
                        LottoWinner::getWinnerClass,
                        Collectors.counting()));
    }

    public Long getWinnerCount(LottoWinnerClass winnerClass) {
        return map.getOrDefault(winnerClass, 0L);
    }

    public double getProfitMargin(LottoPrice price, LottoPrizeInfo prizeInfo) {
        double result = 0.0;
        for (LottoWinnerClass winnerClass : LottoWinnerClass.values()) {
            result += prizeInfo.getPrize(winnerClass) * getWinnerCount(winnerClass);
        }
        return result / (ticketCount * price.getPrice());
    }
}
