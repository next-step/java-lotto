package lotto.domain;

import java.util.List;

public class LottoResult {
    private static final int RATE_HUNDRED = 100;
    private static final int RETURN_ZERO = 0;
    private static final int INIT_ZERO = 0;
    private static final int RETURN_ONE = 1;
    private final List<Lotto> lottos;
    private final LottoNumbers luckyNumbers;
    private final LottoNumber bonusNumber;

    public LottoResult(List<Lotto> lottos, LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        this.lottos = lottos;
        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
    }

    private int totalPrize() {
        int totalPrize = INIT_ZERO;
        for (Lotto lotto : lottos) {
            totalPrize += lotto.getPrize(luckyNumbers, bonusNumber).getPrize();
        }
        return totalPrize;
    }



    public double earningsRate(int quantity) {
        double result = (double)totalPrize() / (double)(quantity * Money.LOTTO_PRICE);
        int tmp = (int)(result * RATE_HUNDRED);
        result = (double)tmp / RATE_HUNDRED;
        return result;
    }

    private int compareMatchCount(int lottoMatchCount, int matchCount) {
        if(lottoMatchCount == matchCount) {
            return RETURN_ONE;
        }
        return RETURN_ZERO;
    }

    public int matchLottoWithBonusCount(int matchCount, boolean matchBonus) {
        int lottoCount = INIT_ZERO;
        for (Lotto lotto : lottos) {
            int lottoMatchCount = lotto.matchCount(luckyNumbers);
            lottoCount += checkBonus(compareMatchCount(lottoMatchCount, matchCount), lotto, matchBonus);
        }

        return lottoCount;
    }

    private int checkBonus(int compareMatchCount, Lotto lotto, boolean matchBonus) {
        boolean isCheckMatchBonus = lotto.isCheckMatchBonus(luckyNumbers, bonusNumber);
        if(isCheckMatchBonus == matchBonus) {
            return compareMatchCount;
        }

        return RETURN_ZERO;
    }
}
