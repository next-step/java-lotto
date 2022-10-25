package domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<LottoNumber> numebrs, LottoNumber bonusLottoNumber) {
        this.lottoNumbers = numebrs;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Rank getRank(Lotto lotto) {
        return Rank.of(this.lottoNumbers.stream()
                .filter(lottoNumber -> lotto.getLottoNumbers().contains(lottoNumber))
                .count(), lotto.getLottoNumbers().contains(bonusLottoNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusLottoNumber, that.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusLottoNumber);
    }
}
