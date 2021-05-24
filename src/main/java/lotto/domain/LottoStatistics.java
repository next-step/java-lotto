package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class LottoStatistics {

    private static final int ADD_COUNT = 1;

    private final WinningCountMap winningCountMap;

    public LottoStatistics(List<WinningType> winningTypes) {

        Map<WinningType, Integer> map =
            winningTypes.stream()
                        .filter(WinningType::isWinningLotto)
                        .collect(groupingBy(
                                Function.identity(),
                                () -> new EnumMap<>(WinningType.class),
                                summingInt(type -> ADD_COUNT)));

        this.winningCountMap = new WinningCountMap(map);
    }

    public List<WinningLottoDto> getStatisticsData() {
        return winningCountMap.getDataSets();
    }

    public double getEarningsRate(int totalLottoSize) {
        return winningCountMap.getTotalPrize() / (double) (totalLottoSize * Money.LOTTO_PRICE);
    }
}
