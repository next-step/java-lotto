package lotto.domains;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {
    private static final long DRAW_A_BLANK = 0L; // 꽝이라는 뜻 이라고 합니다.

    private final long totalPurchased;
    private final Map<Prize, Long> statistics;

    public LottoStatistics(List<Lotto> lottoList, LottoWinner lastWinner) {
        this.totalPurchased = lottoList.size() * LottoGenerator.PRICE;
        this.statistics = lottoList.stream()
                .map(lotto -> lotto.getPrize(lastWinner))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public long getWinningCount(Prize prize) {
        return statistics.getOrDefault(prize, DRAW_A_BLANK);
    }

    public double getYield() {
        if (totalPurchased == 0) {
            return DRAW_A_BLANK;
        }

        return getTotalReward() / (double) totalPurchased;
    }

    private long getTotalReward() {
        return statistics.entrySet()
                .stream()
                .mapToLong(e -> e.getKey().getReward() * e.getValue())
                .reduce(Long::sum)
                .orElse(DRAW_A_BLANK);
    }
}
