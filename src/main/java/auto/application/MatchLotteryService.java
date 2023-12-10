package auto.application;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static auto.application.MatchedAmount.findByCount;

public class MatchLotteryService {
    private static final ConcurrentMap<Integer, Integer> matchedCountMap = MatchedAmount.getMatchedCountMap();

    public Map<Integer, Integer> getMatchedCountMap(List<List<Integer>> lotteryNumbersList,
                                                    List<Integer> winningNumbersLastWeek) {

        for (List<Integer> lotteryNumbers : lotteryNumbersList) {
            setMatchedCountMap(lotteryNumbers, winningNumbersLastWeek);
        }
        return matchedCountMap;
    }

    private void setMatchedCountMap(List<Integer> lotteryNumbers, List<Integer> winningNumbersLastWeek) {
        int matchedCountSum = lotteryNumbers.stream()
                                            .mapToInt(number -> getMatchCount(winningNumbersLastWeek, number))
                                            .sum();
        int matchedCount = findByCount(matchedCountSum).getCount();
        if (matchedCount > 0) {
            matchedCountMap.put(matchedCount, matchedCountMap.get(matchedCount) + 1);
        }
    }

    private int getMatchCount(List<Integer> winningNumbersLastWeek, Integer number) {
        if (winningNumbersLastWeek.contains(number)) {
            return 1;
        }
        return 0;
    }
}
