package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(final Lotto lotto, final LottoNumber bonusBall) {
        this.lotto = lotto;
        if (hasDuplicate(bonusBall)) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
        this.bonusBall = bonusBall;
    }

    private boolean hasDuplicate(LottoNumber bonusBall) {
        return lotto.numbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public boolean isMatchingBonusBall(LottoNumber anotherNumber) {
        return bonusBall.equals(anotherNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
