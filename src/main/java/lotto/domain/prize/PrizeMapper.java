package lotto.domain.prize;

import java.util.HashMap;
import java.util.Map;

public class PrizeMapper {

    private Map<Long, Long> prizeMap;

    public PrizeMapper() {
        LottoPrize[] prizes = LottoPrize.values();
        prizeMap = new HashMap<>(prizes.length);

        for (LottoPrize prize : prizes) {
            prizeMap.put(prize.getCountMatches(), prize.getPrize());
        }
    }

    public long findPrizeByCountMatches(long countMatches) {
        if (prizeMap.containsKey(countMatches)) {
            return prizeMap.get(countMatches);
        }
        return 0;
    }
}
