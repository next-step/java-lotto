package lotto.domain;

import java.util.List;

public class LottoResult {
    private static final int RATE_HUNDRED = 100;
    private static final int RETURN_ZERO = 0;
    private static final int INIT_ZERO = 0;
    private static final int RETURN_ONE = 1;
    private final List<Lotto> lottos;
    private final WinningLottoNumbers winningLottoNumbers;

    public LottoResult(List<Lotto> lottos, WinningLottoNumbers winningLottoNumbers) {
        this.lottos = lottos;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    private int totalPrize() {
        int totalPrize = INIT_ZERO;
        for (Lotto lotto : lottos) {
            totalPrize += lotto.getWinningType(winningLottoNumbers).getPrize();
        }
        return totalPrize;
    }



    public double earningsRate() {
        double result = (double)totalPrize() / (double)(lottos.size() * Money.LOTTO_PRICE);
        int tmp = (int)(result * RATE_HUNDRED);
        result = (double)tmp / RATE_HUNDRED;
        return result;
    }

    private int compareMatchCount(int lottoMatchCount, int targetMatchCount) {
        if(lottoMatchCount == targetMatchCount) {
            return RETURN_ONE;
        }
        return RETURN_ZERO;
    }

    public int matchLottoWithBonusCount(int matchCount, boolean matchBonus) {
        int lottoCount = INIT_ZERO;
        for (Lotto lotto : lottos) {
            int lottoMatchCount = lotto.matchCount(winningLottoNumbers);
            lottoCount += checkBonus(matchCount, compareMatchCount(lottoMatchCount, matchCount), lotto, matchBonus);
        }

        return lottoCount;
    }

    private int checkBonus(int matchCount, int compareMatchCount, Lotto lotto, boolean matchBonus) {
        boolean isCheckMatchBonus = lotto.isCheckMatchBonus(matchCount, winningLottoNumbers);
        if(isCheckMatchBonus == matchBonus) {
            return compareMatchCount;
        }

        return RETURN_ZERO;
    }
}
