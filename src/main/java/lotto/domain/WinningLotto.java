package lotto.domain;

public class WinningLotto {

    private final Lotto luckyLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto luckyLotto, LottoNumber bonusNumber) {
        if (luckyLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 포함되지 않아야 합니다.");
        }
        this.luckyLotto = luckyLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchingCount(Lotto lotto) {
        return lotto.draw(luckyLotto);
    }

    public boolean getMatchBonus(Lotto lotto) {
        return lotto.drawBonus(getMatchingCount(lotto), bonusNumber);
    }

}
