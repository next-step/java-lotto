package auto.application;

import java.util.List;
import java.util.Map;

import static auto.application.MatchedAmount.findByCount;

public class MatchService {
    private static final Map<Integer, Integer> matchedCountMap = MatchedAmount.getMatchedCountMap();

    public Map<Integer, Integer> getMatchedCountMap(List<List<Integer>> lotteryNumbersList,
                                                    List<Integer> winningNumbersLastWeek) {

        for (List<Integer> lotteryNumbers : lotteryNumbersList) {
            setMatchedCountMap(lotteryNumbers, winningNumbersLastWeek);
        }
        return matchedCountMap;
    }

    private void setMatchedCountMap(List<Integer> lotteryNumbers, List<Integer> winningNumbersLastWeek) {
        int matchedCountSum = lotteryNumbers.stream()
                                            .mapToInt(number -> winningNumbersLastWeek.contains(number) ? 1 : 0)
                                            .sum();
        int matchedCount = findByCount(matchedCountSum).getCount();
        if (matchedCount > 0) {
            matchedCountMap.put(matchedCount, matchedCountMap.get(matchedCount) + 1);
        }
    }
}
