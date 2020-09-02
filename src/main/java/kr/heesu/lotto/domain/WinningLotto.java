package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;

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

    public static WinningLotto of(String stringLotto, String stringLottoNumber) {
        return new WinningLotto(
                Lotto.of(stringLotto),
                LottoNumber.of(stringLottoNumber)
        );
    }

    public boolean contains(LottoNumber number) {
        return this.winnningLotto.contain(number);
    }

    public Rank match(Lotto lotto) {
        Long count = winnningLotto.contains(lotto);
        return Rank.valueOf(count, lotto.contain(bonusNumber));
    }

    public LottoNumber getBounusNumber() {
        return this.bonusNumber;
    }
}

