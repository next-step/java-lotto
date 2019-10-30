package step3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LottoLottery 클래스의 필드를 클래스로 전환
 */
public class StatisticResult {

    private static final int MATCHING_LIMIT = 3;
    public Map<Integer, Integer> statisticResult = new HashMap<>();

    public StatisticResult() {
        for (int i = MATCHING_LIMIT; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            this.statisticResult.put(i, 0);
        }
    }

    public StatisticResult(List<Integer> resultMatching) {
        int index = 0;
        for (int value : resultMatching) {
            this.statisticResult.put(index, value);
            index++;
        }
    }

    public boolean bonusValidCheck(StatisticResult statisticResult) {
        Map<Integer, Integer> resultMatching = beforeInstance(statisticResult);
        for (int key : resultMatching.keySet()) {
            LottoLottery.updateBonusNumberIndex(resultMatching, key);
        }
        return resultMatching.containsValue(LottoGenerator.BONUS_WINNING_VALID_NUMBER);
    }

    public static Map<Integer, Integer> beforeInstance(StatisticResult statisticResult) {
        return statisticResult.statisticResult;
    }

    public static Map<Integer, Integer> lottosInRank(List<Integer> resultMatching) {
        List<Integer> winningLottos = resultMatching.stream().filter(x -> x >= MATCHING_LIMIT).collect(Collectors.toList());
        Collections.sort(winningLottos);

        return countByRank(winningLottos);
    }

    private static Map<Integer, Integer> countByRank(List<Integer> winningLottos) {
        Map<Integer, Integer> summaryResult = beforeInstance(new StatisticResult());
        for (int key : winningLottos) {
            summaryResult.put(key, summaryResult.get(key) + 1);
        }
        return summaryResult;
    }
}
