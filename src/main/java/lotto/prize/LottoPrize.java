package lotto.prize;

import lotto.result.LottoResult;

import java.util.Map;
import java.util.TreeMap;

public class LottoPrize {
    private static final int DEFAULT_PRIZE = 0;
    private static final int MATCHED_THREE_LOTTO_NUMBER = 3;
    private static final int MATCHED_THREE_LOTTO_NUMBER_PRIZE = 5000;
    private static final int MATCHED_FOUR_LOTTO_NUMBER = 4;
    private static final int MATCHED_FOUR_LOTTO_NUMBER_PRIZE = 50000;
    private static final int MATCHED_FIVE_LOTTO_NUMBER = 5;
    private static final int MATCHED_FIVE_LOTTO_NUMBER_PRIZE = 1500000;
    private static final int MATCHED_SIX_LOTTO_NUMBER = 6;
    private static final int MATCHED_SIX_LOTTO_NUMBER_PRIZE = 2000000000;

    private final Map<LottoResult, Integer> prizeMap = new TreeMap<>();

    public LottoPrize() {
        prizeMap.put(new LottoResult(MATCHED_THREE_LOTTO_NUMBER), MATCHED_THREE_LOTTO_NUMBER_PRIZE);
        prizeMap.put(new LottoResult(MATCHED_FOUR_LOTTO_NUMBER), MATCHED_FOUR_LOTTO_NUMBER_PRIZE);
        prizeMap.put(new LottoResult(MATCHED_FIVE_LOTTO_NUMBER), MATCHED_FIVE_LOTTO_NUMBER_PRIZE);
        prizeMap.put(new LottoResult(MATCHED_SIX_LOTTO_NUMBER), MATCHED_SIX_LOTTO_NUMBER_PRIZE);
    }

    public int getLottoPrize(LottoResult lottoResult) {
        return prizeMap.getOrDefault(lottoResult, DEFAULT_PRIZE);
    }
}
