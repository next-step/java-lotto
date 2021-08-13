package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
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
        return (float)(Math.floor(prizeMoneySum / (lottoCount * 10.0f)) / 100.0f);
    }

    public Map<Rank, Integer> calculateStatistics(WinnerNumbers winnerNumbers) {
        Map<Rank, Integer> winStatisticsDTO = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = winnerNumbers.decideRank(lottoTicket);
            winStatisticsDTO.put(rank, winStatisticsDTO.getOrDefault(rank, 0) + 1);
        }
        return winStatisticsDTO;
    }

}
