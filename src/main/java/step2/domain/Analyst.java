package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analyst {
    public static final Map<Integer, Integer> REVENUE_TABLE = Map.of(
            0, 0,
            1, 0,
            2, 0,
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private final List<LottoNumbers> targetData;

    private final LottoNumbers winLottoNumbers;

    private Map<Integer, Long> countByRank;


    public Analyst(List<LottoNumbers> targetData, LottoNumbers winLottoNumbers) {
        this.targetData = targetData;
        this.winLottoNumbers = winLottoNumbers;
        analyseMatchCount();
    }

    public Map<Integer, Long> getCountByRank() {
        return countByRank;
    }

    public float revenueRatio() {
        return ((float) totalRevenue()) / targetData.size();
    }


    private void analyseMatchCount() {
        this.countByRank = this.targetData.stream()
                .map(lottoNumbers -> lottoNumbers.compareMatch(this.winLottoNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private int totalRevenue() {
        return this.countByRank.entrySet().stream()
                .map(entries -> REVENUE_TABLE.get(entries.getKey()) * entries.getValue() / 1000)
                .mapToInt(Long::intValue)
                .sum();
    }
}
