package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final int... intLottoNumbers) {
        this.lottoNumbers = Arrays.stream(intLottoNumbers)
                                  .mapToObj(LottoNumber::new)
                                  .collect(Collectors.toList());
    }

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


    private int countOfMatch(final List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            return 0;
        }

        return (int) lottoNumbers.stream()
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
