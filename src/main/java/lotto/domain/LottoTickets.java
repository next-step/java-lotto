package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoBalls> lottoTickets;

    public LottoTickets(List<LottoBalls> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Integer, Integer> getLottoStatistics(LottoBalls winnerNumbers) {
        Map<Integer, Integer> winStatistics = new HashMap<>();
        for (LottoBalls lottoTicket : lottoTickets) {
            int key = lottoTicket.countMatchNumber(winnerNumbers);
            winStatistics.put(key, winStatistics.getOrDefault(key, 0) + 1);
        }
        return winStatistics;
    }

    public long calculatePrizeMoney(int matchCount, int lottoCount) {
        Rank rank = Arrays.stream(Rank.values())
            .filter(e -> matchCount == e.getMatchCount())
            .findFirst()
            .orElse(Rank.NO_RANK);

        return rank.getMoney()
            .multiply(lottoCount)
            .amount();
    }

    public float getRateOfReturn(int lottoCount, Map<Integer, Integer> winStatistics) {
        long prizeMoneySum = winStatistics.entrySet().stream()
            .mapToLong(e -> calculatePrizeMoney(e.getKey(), e.getValue()))
            .sum();
        return (float)(Math.floor(prizeMoneySum / (lottoCount * 10.0f)) / 100.0f);

    }
}
