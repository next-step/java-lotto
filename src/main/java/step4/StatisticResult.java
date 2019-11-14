package step4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public StatisticResult(List<LottoNumber> resultMatching) {
        int index = 0;
        for (LottoNumber value : resultMatching) {
            this.statisticResult.put(index, LottoNumber.valueOf(value));
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

    public static Map<Integer, Integer> lottosInRank(List<LottoNumber> resultMatching) {
        List<LottoNumber> winningLottos = resultMatching.stream().filter(x -> LottoNumber.valueOf(x) >= MATCHING_LIMIT).collect(Collectors.toList());
        Collections.sort(winningLottos);

        return countByRank(winningLottos);
    }

    private static Map<Integer, Integer> countByRank(List<LottoNumber> winningLottos) {
        Map<Integer, Integer> summaryResult = beforeInstance(new StatisticResult());
        for (LottoNumber key : winningLottos) {
            int lottoKey = LottoNumber.valueOf(key);
            summaryResult.put(lottoKey, summaryResult.get(lottoKey) + 1);
        }
        return summaryResult;
    }
}
