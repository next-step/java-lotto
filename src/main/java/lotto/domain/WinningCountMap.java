package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class WinningCountMap {

    private static final int IF_ABSENT_TYPE_DEFAULT_VALUE = 0;

    private final Map<WinningType, Integer> winningCounterMap;

    public WinningCountMap(Map<WinningType, Integer> map) {

        Arrays.stream(WinningType.values())
              .filter(WinningType::isWinningLotto)
              .forEach(type -> map.putIfAbsent(type, IF_ABSENT_TYPE_DEFAULT_VALUE));

        winningCounterMap = Collections.unmodifiableMap(map);
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
