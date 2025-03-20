package lotto.model;

public class LottoWinner {
    private final Lotto winnerNumber;

    public LottoWinner(Lotto winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    public LottoPrize getRank(Lotto lotto) {
        int matchCount = winnerNumber.getMatchCount(lotto);
        return LottoPrize.valueOf(matchCount);
    }


}
