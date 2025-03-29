package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lotto.domain.PrizeLevel;
import lotto.dto.LottoStatisticsDTO;

public class LottoStatisticsService {
    private final Map<PrizeLevel, Integer> statistics;

    public LottoStatisticsService(Map<PrizeLevel, Integer> statistics) {
        this.statistics = statistics;
    }

    public List<LottoStatisticsDTO> getLottoStatisticsDTOs() {
       return statistics.entrySet().stream()
            .filter(this::hasWinningPrize)
            .map(entry -> formatEntry(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    }

    private boolean hasWinningPrize(Entry<PrizeLevel, Integer> entry) {
        return entry.getKey().getPrice() > 0;
    }

    public double getProfitRate(int money) {
        int totalPrize = statistics.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();

        return (double) totalPrize / money;
    }

    private LottoStatisticsDTO formatEntry(PrizeLevel level, int count) {
        return new LottoStatisticsDTO(level, count);
    }
}
