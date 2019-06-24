package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class LottoResult {
    private List<Integer> lottoResult;
    public Map<Integer, Integer> PRIZE_MONEY;


    public LottoResult(List<Integer> lottoResult) {
        PRIZE_MONEY = new HashMap<>();
        PRIZE_MONEY.put(3, 5000);
        PRIZE_MONEY.put(4, 50000);
        PRIZE_MONEY.put(5, 1500000);
        PRIZE_MONEY.put(6, 2000000000);
        this.lottoResult = lottoResult;
    }

    public Map<Integer, List<Integer>> resultSummary() {
        return lottoResult.stream().collect(groupingBy(Integer::intValue));
    }

    public int rateOfReturn(int rank, Map<Integer, List<Integer>> summary) {
        return PRIZE_MONEY.get(rank) * summary.get(rank).size();
    }

    public int rateOfReturnAll() {
        Map<Integer, List<Integer>> summary = resultSummary();
        Set<Integer> keys = summary.keySet();
        int result = 0;
        for (int key : keys) {
            result += summary.get(key).size() * PRIZE_MONEY.get(key);
        }
        return result;
    }
}
