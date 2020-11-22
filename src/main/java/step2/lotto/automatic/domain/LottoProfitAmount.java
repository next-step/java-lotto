package step2.lotto.automatic.domain;

import java.util.Map;

public class LottoProfitAmount {
    private static final int MATCH_LOTTE_MAX_COUNT = 4;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    public static int runLottoProfitAmount(Map<Integer, LottoStatusEnum> lottoResult) {
        int count = 0;
        for (int i = MATCH_LOTTE_MIN_COUNT; i <= MATCH_LOTTE_MAX_COUNT; i++) {
            count = count + (lottoResult.get(i).getPrice() * lottoResult.get(i).getWinningCount());
        }

        return count;
    }


}
