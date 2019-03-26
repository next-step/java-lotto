package domain;

public class WinningLotto {

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(NumberSet winningNumbers, Integer bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        this.winningNumbers = Lotto.create(winningNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Rank matchLotto(Lotto lotto) {
        return Rank.calculate(
            winningNumbers.matchCount(lotto),
            lotto.contains(bonusNumber));
    }
}
