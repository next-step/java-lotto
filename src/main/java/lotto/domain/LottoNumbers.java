package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = IntStream.range(0, 6)
                .mapToObj(it -> new LottoNumber())
                .collect(Collectors.toList());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers sort() {
        List<LottoNumber> sortedLottoNumbers = this.lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(sortedLottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
