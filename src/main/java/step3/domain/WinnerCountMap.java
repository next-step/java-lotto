package step3.domain;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class WinnerCountMap {

    private final Map<Integer, PrizeCalculator> winnerCounterMap;

    public WinnerCountMap() {
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
}
