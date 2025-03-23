package lotto.model;

public class LottoWinningNumber {

    private final Lotto winnerNumber;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(Lotto winnerNumber, LottoNumber bonusNumber) {
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize getRank(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winnerNumber);
        boolean matchBonus = lotto.hasNumber(bonusNumber);
        return LottoPrize.valueOf(matchCount, matchBonus);
    }

}
