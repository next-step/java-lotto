package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호는 보너스볼의 번호를 포함할 수 없습니다.");
        }
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize calculatePrize(Lotto lotto) {
        int matchCount = lotto.countMatchNumbers(winningLotto);
        boolean matchBonus = lotto.matchesBonusNumber(bonusNumber);
        return Prize.valueOf(matchCount, matchBonus);
    }
}
