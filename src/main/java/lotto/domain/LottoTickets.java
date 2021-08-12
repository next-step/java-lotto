package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoTickets {
    private final List<LottoBalls> lottoTickets;

    private LottoTickets(List<LottoBalls> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<LottoBalls> lottoTickets) {
        return new LottoTickets(lottoTickets);
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

    public float getRateOfReturn(int lottoCount, WinStatistics winStatistics) {
        long prizeMoneySum = winStatistics.result()
            .entrySet()
            .stream()
            .mapToLong(e -> calculatePrizeMoney(e.getKey(), e.getValue()))
            .sum();
        return (float) (Math.floor(prizeMoneySum / (lottoCount * 10.0f)) / 100.0f);
    }

    public List<LottoBalls> toLottoBallsList() {
        return this.lottoTickets;
    }
}
