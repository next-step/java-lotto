package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    LottoRank match(Lotto userLotto) {
        int matchedCount = lotto.countMatchedNumbers(userLotto);
        boolean isBonus = userLotto.isBonus(bonusNumber);
        return LottoRank.findByMatchedCountAndBonus(matchedCount, isBonus);
    }
}
