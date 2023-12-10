package auto.application;

import auto.domain.Lotto;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static auto.application.MatchedAmount.NONE;
import static auto.application.MatchedAmount.findByCount;

public class MatchService {
    private static final Map<MatchedAmount, Integer> matchedCountMap = new HashMap<>();// = MatchedAmount.getMatchedCountMap();

    private static void setUpWinningStatisticsMap() {
        EnumSet.allOf(MatchedAmount.class)
               .stream()
               .filter(matchedAmount -> matchedAmount != NONE)
               .sorted()
               .forEach(matchedAmount -> matchedCountMap.put(matchedAmount, 0));
    }

    static boolean isMatchedBonusNumber(List<Integer> lottoNumbers,
                                        List<Integer> winningNumbersLastWeek,
                                        int bonusBallNumber) {
        List<Integer> copyLottoNumbers = new ArrayList<>(lottoNumbers);
        copyLottoNumbers.removeAll(winningNumbersLastWeek);
        return copyLottoNumbers.contains(bonusBallNumber);
    }

    public Map<MatchedAmount, Integer> getMatchedCountMap(List<Lotto> lottoNumbersList,
                                                          List<Integer> winningNumbersLastWeek,
                                                          int bonusBallNumber) {
        setUpWinningStatisticsMap();
        for (Lotto lotto : lottoNumbersList) {
            setMatchedCountMap(lotto.getNumbers(),
                               winningNumbersLastWeek,
                               isMatchedBonusNumber(lotto.getNumbers(), winningNumbersLastWeek, bonusBallNumber));
        }
        return matchedCountMap;
    }

    private void setMatchedCountMap(List<Integer> lottoNumbers,
                                    List<Integer> winningNumbersLastWeek,
                                    boolean isMatchedBonusNumber) {
        int matchedCountSum = lottoNumbers.stream()
                                          .mapToInt(number -> winningNumbersLastWeek.contains(number) ? 1 : 0)
                                          .sum();
        MatchedAmount matchedAmount = findByCount(matchedCountSum, isMatchedBonusNumber);
        if (matchedAmount.getCount() > 0) {
            matchedCountMap.put(matchedAmount, matchedCountMap.get(matchedAmount) + 1);
        }
    }
}
