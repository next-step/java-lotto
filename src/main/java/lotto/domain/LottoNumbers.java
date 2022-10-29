package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LottoNumbers {

    List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int countOfMatch(final LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            return 0;
        }

        return this.countOfMatch(lottoNumbers.getLottoNumbers());
    }


    public int countOfMatch(final List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            return 0;
        }

        return (int) lottoNumbers.stream()
                                 .map(Optional::ofNullable)
                                 .filter(Optional::isPresent)
                                 .map(Optional::get)
                                 .filter(this.lottoNumbers::contains)
                                 .count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
