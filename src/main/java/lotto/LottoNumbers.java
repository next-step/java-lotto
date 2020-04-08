package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static LottoNumbers create(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
