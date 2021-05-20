package step3.domain;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class WinningCountMap {

    private final Map<Integer, PrizeCalculator> winnerCounterMap;

    public WinningCountMap() {
        winnerCounterMap = Stream.iterate(3, i -> i + 1)
                                 .limit(4)
                                 .collect(toMap(i -> i, PrizeCalculator::new));
        winnerCounterMap.put(0, new PrizeCalculator(0));
    }

    void addCount(int matchCount) {
        winnerCounterMap.computeIfPresent(matchCount, (count, prizeCalculator) -> {
            prizeCalculator.addCount();
            return prizeCalculator;
        });
    }

    public long getResultOf(int matchCount) {
        return winnerCounterMap.getOrDefault(matchCount, winnerCounterMap.get(0))
                               .getResult();
    }

    public long getTotalResult() {
        return winnerCounterMap.values()
                               .stream()
                               .mapToLong(PrizeCalculator::getResult)
                               .sum();
    }

    public String toStringOf(int matchCount) {
        validateMatchCount(matchCount);
        return winnerCounterMap.get(matchCount)
                               .toString();
    }

    private void validateMatchCount(int matchCount) {
        if (matchCount < 3 || matchCount > 6) {
            throw new IllegalArgumentException("맞은 숫자의 개수가 3개부터 6개까지인 데이터만 출력할 수 있습니다.");
        }
    }
}
