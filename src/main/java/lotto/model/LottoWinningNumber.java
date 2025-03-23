package lotto.model;

public class LottoWinningNumber {

    private final Lotto winnerNumber;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(Lotto winnerNumber, LottoNumber bonusNumber) {
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;

        if (winnerNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 넘버는 당첨 번호와 일치할 수 없습니다.");
        }
    }

    public LottoPrize getRank(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winnerNumber);
        boolean matchBonus = lotto.hasNumber(bonusNumber);
        return LottoPrize.valueOf(matchCount, matchBonus);
    }

}
