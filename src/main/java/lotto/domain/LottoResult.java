package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public static final int EMPTY_KEY_RESULT_COUNT = 0;
    private final Map<Integer, Integer> sameCountMap;

    public LottoResult(List<Lotto> lottoList, Lotto winnerLotto) {
        sameCountMap = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int numberCount = lotto.sameNumberCount(winnerLotto);

            if (! sameCountMap.containsKey(numberCount))
                sameCountMap.put(numberCount, 0);

            Integer integer = sameCountMap.get(numberCount);
            sameCountMap.put(numberCount, integer + 1);
        }
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
