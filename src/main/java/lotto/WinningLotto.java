package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(final Lotto lotto, final LottoNumber bonusBall) {
        this.lotto = lotto;
        if (lotto.hasBonusBall(bonusBall)) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
        this.bonusBall = bonusBall;
    }

    public int countNumberOfMatch(Lotto anotherLotto) {
        return lotto.countNumberOfMatch(anotherLotto);
    }

    public boolean isAnyMatchingBonusBall(Lotto anotherLotto) {
        return anotherLotto.hasBonusBall(bonusBall);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
