package kr.heesu.lotto.domain;

public class WinningLotto {

    private final Lotto winnningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.winnningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winnningLotto, LottoNumber bonusNumber) {
        return new WinningLotto(winnningLotto, bonusNumber);
    }

    public boolean contains(LottoNumber number) {
        return this.winnningLotto.contain(number);
    }

    public LottoNumber getBounusNumber() {
        return this.bonusNumber;
    }
}

