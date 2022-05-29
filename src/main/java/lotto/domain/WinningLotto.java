package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        validBonusNumber(lotto, this.bonusNumber);
    }

    private void validBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼의 숫자는 6개의 로또 번호와 달라야 합니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(lottoNumber -> this.lotto.getNumbers().contains(lottoNumber))
                .count();
    }

    boolean isMatchBonus(Lotto lotto) {
        return lotto.isContain(this.bonusNumber);
    }

}

