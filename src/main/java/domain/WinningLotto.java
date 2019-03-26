package domain;

public class WinningLotto {

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Integer[] winningNumbers, Integer bonusNumber) {
        this.winningNumbers = Lotto.create(winningNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);

        duplicateCheck();
    }

    private void duplicateCheck() {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Rank matchLotto(Lotto lotto) {
        return Rank.calculate(
            winningNumbers.matchCount(lotto),
            lotto.contains(bonusNumber));
    }
}
