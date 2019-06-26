package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        if (this.winningLotto.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Rank match(Lotto userLotto) {
        int matchCount = winningLotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Rank.of(matchCount, matchBonus);
    }
}
