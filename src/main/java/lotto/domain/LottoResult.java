package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int EMPTY_KEY_RESULT_COUNT = 0;
    private static final int INITIAL_COUNT = 0;
    private final Map<Integer, Integer> sameCountMap;

    public LottoResult(List<Lotto> lottoList, Lotto winnerLotto) {
        sameCountMap = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int numberCount = lotto.sameNumberCount(winnerLotto);

            if (! sameCountMap.containsKey(numberCount))
                sameCountMap.put(numberCount, INITIAL_COUNT);

            increaseCount(numberCount);
        }
    }

    private void increaseCount(int numberCount) {
        Integer matchCount = sameCountMap.get(numberCount);
        sameCountMap.put(numberCount, matchCount + 1);
    }

    public int getSameLottoCount(int sameCount) {
        if (! sameCountMap.containsKey(sameCount)) {
            return EMPTY_KEY_RESULT_COUNT;
        }
        return sameCountMap.get(sameCount);
    }

    public double getRevenueRate(int amount) {
        int totalRevenue = 0;
        for (Integer sameCount : sameCountMap.keySet()) {
            totalRevenue += RevenueTable.getRevenue(sameCount);
        }
        return (double)totalRevenue / amount;
    }
}
