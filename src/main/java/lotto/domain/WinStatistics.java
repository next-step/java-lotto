package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class WinStatistics {
    private final Map<Rank, Integer> winStatistics;

    private WinStatistics(Map<Rank, Integer> winStatistics) {
        this.winStatistics = winStatistics;
    }

    private WinStatistics(WinnerNumbers winnerNumbers, LottoTickets lottoTickets) {
        winStatistics = Collections.unmodifiableMap(
            lottoTickets.calculateStatistics(winnerNumbers)
                .result()
        );
    }

    public static WinStatistics from(Map<Rank, Integer> winStatistics) {
        return new WinStatistics(winStatistics);
    }

    public static WinStatistics from(WinnerNumbers winnerNumbers, LottoTickets lottoTickets) {
        return new WinStatistics(winnerNumbers, lottoTickets);
    }

    private long calculatePrizeMoney(Rank rank, int lottoCount) {
        Rank rankResult = Arrays.stream(Rank.values())
            .filter(e -> e == rank)
            .findFirst()
            .orElse(Rank.MISS);

        return rankResult.money()
            .multiply(lottoCount)
            .amount();
    }

    public float getRateOfReturn(int lottoCount) {
        long prizeMoneySum = winStatistics
            .entrySet()
            .stream()
            .mapToLong(e -> calculatePrizeMoney(e.getKey(), e.getValue()))
            .sum();
        return (float)(Math.floor(prizeMoneySum / (lottoCount * 10.0f)) / 100.0f);
    }

    public Map<Rank, Integer> result() {
        return Collections.unmodifiableMap(winStatistics);
    }
}
