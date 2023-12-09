package auto.application;

import auto.domain.Lotto;

import java.util.List;
import java.util.Map;

import static auto.application.MatchedAmount.findByCount;

public class MatchService {
    private static final Map<Integer, Integer> matchedCountMap = MatchedAmount.getMatchedCountMap();

    public Map<Integer, Integer> getMatchedCountMap(List<Lotto> lottoNumbersList,
                                                    List<Integer> winningNumbersLastWeek) {

        for (Lotto lotto : lottoNumbersList) {
            setMatchedCountMap(lotto, winningNumbersLastWeek);
        }
        return matchedCountMap;
    }

    private void setMatchedCountMap(Lotto lotto, List<Integer> winningNumbersLastWeek) {
        int matchedCountSum = lotto.getNumbers()
                                   .stream()
                                   .mapToInt(number -> winningNumbersLastWeek.contains(number) ? 1 : 0)
                                   .sum();
        int matchedCount = findByCount(matchedCountSum).getCount();
        if (matchedCount > 0) {
            matchedCountMap.put(matchedCount, matchedCountMap.get(matchedCount) + 1);
        }
    }
}
