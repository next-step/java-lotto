package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class WinningCountMap {

    private final Map<WinningType, Integer> winningCounterMap;

    public WinningCountMap() {
        winningCounterMap = Arrays.stream(WinningType.values())
                                  .filter(type -> type != WinningType.NONE)
                                  .collect(toMap(Function.identity(), type -> 0));
    }

    public void addCount(WinningType winningType) {
        winningCounterMap.merge(winningType, 1, Integer::sum);
    }

    public long getTotalPrize() {
        return winningCounterMap.keySet()
                                .stream()
                                .mapToLong(this::getTotalPrizeOf)
                                .sum();
    }

    public List<WinningLottoDto> getDataSets() {
        return winningCounterMap.entrySet()
                                .stream()
                                .filter(entry -> entry.getKey() != WinningType.NONE)
                                .map(entry -> WinningLottoDto.of(entry.getKey(), entry.getValue()))
                                .sorted(Comparator.comparing(WinningLottoDto::getPrize)
                                                  .reversed())
                                .collect(toList());
    }

    private long getTotalPrizeOf(WinningType winningType) {
        return (long) winningType.getPrize() * (long) winningCounterMap.get(winningType);
    }
}
