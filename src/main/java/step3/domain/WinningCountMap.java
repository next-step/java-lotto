package step3.domain;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class WinningCountMap {

    private final Map<WinningType, Integer> winningCounterMap;

    public WinningCountMap() {
        winningCounterMap = Arrays.stream(WinningType.values())
                                  .filter(type -> type != WinningType.NONE)
                                  .collect(toMap(type -> type, type -> 0));
    }

    public void addCount(int matchCount) {
        winningCounterMap.merge(findType(matchCount), 1, Integer::sum);
    }

    public long getResultOf(int matchCount) {
        return getPrizeOf(findType(matchCount));
    }

    public long getTotalResult() {
        return winningCounterMap.keySet()
                                .stream()
                                .mapToLong(this::getPrizeOf)
                                .sum();
    }

    public String toStringOf(int matchCount) {
        validateMatchCount(matchCount);
        WinningType winningType = findType(matchCount);
        return winningType.toResultString(winningCounterMap.get(winningType));
    }

    private long getPrizeOf(WinningType winningType) {
        return (long) winningType.getPrize() * (long) winningCounterMap.getOrDefault(winningType, 0);
    }

    private void validateMatchCount(int matchCount) {
        if (matchCount < 3 || matchCount > 6) {
            throw new IllegalArgumentException("맞은 숫자의 개수가 3개부터 6개까지인 데이터만 출력할 수 있습니다.");
        }
    }

    private WinningType findType(int matchCount) {
        return WinningType.ofMatchCount(matchCount);
    }
}
