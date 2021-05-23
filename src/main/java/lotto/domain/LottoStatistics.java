package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoStatistics {

    private final WinningCountMap winningCountMap;

    public LottoStatistics(WinningLotto winningLotto, List<Lotto> lottos) {

        Map<WinningType, Integer> map =
            lottos.stream()
                  .map(winningLotto::getWinningType)
                  .filter(WinningType::isWinningLotto)
                  .collect(groupingBy(Function.identity(), countingInt()));

        this.winningCountMap = new WinningCountMap(map);
    }

    public List<WinningLottoDto> getStatisticsData() {
        return winningCountMap.getDataSets();
    }

    public double getEarningsRate(int totalLottoSize) {
        return winningCountMap.getTotalPrize() / (double) (totalLottoSize * Money.LOTTO_PRICE);
    }

    private Collector<WinningType, ?, Integer> countingInt() {
        return Collectors.reducing(0, e -> 1, Integer::sum);
    }
}
