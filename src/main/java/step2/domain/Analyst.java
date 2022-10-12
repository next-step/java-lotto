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

    private final List<LottoNumber> targetData;

    private final LottoNumber winLottoNumber;

    public Analyst(List<LottoNumber> targetData, LottoNumber winLottoNumber) {
        this.targetData = targetData;
        this.winLottoNumber = winLottoNumber;
    }

    public Map<Integer, Long> getCountByRank() {
        return this.targetData.stream()
                .map(lottoNumber -> lottoNumber.compareMatch(this.winLottoNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public float revenueRatio(Map<Integer, Long> countByRank) {
        return ((float) totalRevenue(countByRank)) / targetData.size();
    }

    private long totalRevenue(Map<Integer, Long> countByRank) {
        return countByRank.entrySet().stream()
                .map(entries -> REVENUE_TABLE.get(entries.getKey()) * entries.getValue() / 1000)
                .reduce(0L, Long::sum);
    }
}
