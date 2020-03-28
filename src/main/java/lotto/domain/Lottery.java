package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottery {

    private List<LottoNumber> lottoNumbers;

    public Lottery(final List<LottoNumber> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumberSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers != null && lottoNumbers.size() != 6) {
            throw new RuntimeException("로또 번호는 6개 숫자만 가집니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lottery lottery = (Lottery) o;
        return Objects.equals(lottoNumbers, lottery.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
