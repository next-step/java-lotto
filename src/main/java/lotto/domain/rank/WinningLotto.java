package lotto.domain.rank;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.application.WinningLottoRequest;

import java.util.Objects;

public class WinningLotto {
    private static final int COUNT_ONE = 1;

    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new BonusNumber(lottoNumbers, bonusNumber);
    }

    public static WinningLotto of(WinningLottoRequest winningDto) {
        return new WinningLotto(winningDto.getLottoNumbers(), winningDto.getBonusNumber());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isMatchBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers()
                .stream()
                .filter(lottoNumber -> lottoNumber.isEqualBonusNumber(bonusNumber))
                .count() == COUNT_ONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return getLottoNumbers().getLottoNumbers().containsAll(that.getLottoNumbers().getLottoNumbers()) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers(), bonusNumber);
    }
}
