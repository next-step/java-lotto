package domain;

public class WinningLotto {

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank matchLotto(Lotto lotto) {
        return Rank.calculate(
            winningNumbers.matchCount(lotto),
            lotto.contains(bonusNumber));
    }
}
