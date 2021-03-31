package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class LottoNumbers {

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(final Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(final Set<LottoNumber> lottoNumbers) {
       return new LottoNumbers(new TreeSet(lottoNumbers));
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
