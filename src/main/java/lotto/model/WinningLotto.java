package lotto.model;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String lottoText, String bonusText) {
        this(new Lotto(lottoText), new LottoNumber(bonusText));
    }

    public WinningLotto(List<Integer> lottoNumber, Integer bonusNumber) {
        this(new Lotto(lottoNumber), new LottoNumber(bonusNumber));
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호를 제외한 숫자여야 합니다!");
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean containLottoNumber(LottoNumber lottoNumber) {
        return lotto.contain(lottoNumber);
    }

    public boolean isSameBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }

}
