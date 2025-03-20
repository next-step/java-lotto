package lotto.model;

public class LottoWinningNumber {

    private final Lotto winnerNumber;

    public LottoWinningNumber(Lotto winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    public LottoPrize getRank(Lotto lotto) {
        int matchCount = winnerNumber.getMatchCount(lotto);
        return LottoPrize.valueOf(matchCount);
    }


}
