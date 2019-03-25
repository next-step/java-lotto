package lotto.domain;

import java.util.List;

public class LottoResult {
    private static final int RATE_HUNDRED = 100;
    private static final int RETURN_ZERO = 0;
    private static final int INIT_ZERO = 0;
    private static final int RETURN_ONE = 1;
    private final List<Lotto> lottos;
    private final LottoNumbers luckyNumbers;

    public LottoResult(List<Lotto> lottos, LottoNumbers luckyNumbers) {
        this.lottos = lottos;
        this.luckyNumbers = luckyNumbers;
    }

    private int totalPrize() {
        int total = 0;
        for (Lotto lotto : lottos) {
            total += lotto.prize(luckyNumbers);
        }
        return total;
    }



    public double earningsRate(int quantity) {
        double result = (double)totalPrize() / (double)(quantity * Money.LOTTO_PRICE);
        int tmp = (int)(result * RATE_HUNDRED);
        result = (double)tmp / RATE_HUNDRED;
        return result;
    }

    public int matchLottoCount(int matchCount) {
        int lottoCount = INIT_ZERO;
        for (Lotto lotto : lottos) {
            int lottoMatchCount = lotto.matchCount(luckyNumbers);
            lottoCount += compareMatchCount(lottoMatchCount, matchCount);
        }

        return lottoCount;
    }

    private int compareMatchCount(int lottoMatchCount, int matchCount) {
        if(lottoMatchCount == matchCount) {
            return RETURN_ONE;
        }
        return RETURN_ZERO;
    }
}
