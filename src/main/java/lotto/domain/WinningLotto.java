package lotto.domain;

public class WinningLotto {
    private Lotto winner;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winner, int bonusNumber) {
        this.winner = winner;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningType findWinningType(Lotto compare) {
        return WinningType.valueOf(compare.countHits(winner), compare.matchBonus(bonusNumber));
    }
}
