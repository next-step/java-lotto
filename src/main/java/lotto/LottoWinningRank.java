package lotto;

import java.util.Collection;

public enum LottoWinningRank {
    NONE(0),
    MATCHES_THREE(5_000),
    MATCHES_FOUR(50_000),
    MATCHES_FIVE(1_500_000),
    MATCHES_SIX(2_000_000_000);

    private final int winningAmount;

    LottoWinningRank(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public static LottoWinningRank getWinningRank(Collection<Integer> winningNumbers, Collection<Integer> boughtLottoNumbers) {
        int matchCount = 0;

        for (Integer boughtLottoNumber : boughtLottoNumbers) {
            if (winningNumbers.contains(boughtLottoNumber)) {
                matchCount++;
            }
        }

        if (matchCount == 6) {
            return MATCHES_SIX;
        } else if (matchCount == 5) {
            return MATCHES_FIVE;
        } else if (matchCount == 4) {
            return MATCHES_FOUR;
        } else if (matchCount == 3) {
            return MATCHES_THREE;
        } else {
            return NONE;
        }
    }
}
