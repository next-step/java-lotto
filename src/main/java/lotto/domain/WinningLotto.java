package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
        this.lotto = lotto;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Rank.of(matchCount, matchBonus);
    }
}
