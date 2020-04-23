package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.bonusNumber = LottoNumber.of(bonusNumber);
        this.winningLotto = winningLotto;
    }

    public Rank match(Lotto buyLotto) {
        boolean isContainsBonus = buyLotto.contains(bonusNumber);
        return Rank.valueOf(winningLotto.match(buyLotto), isContainsBonus);
    }

}
