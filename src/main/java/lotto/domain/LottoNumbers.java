package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        validateDuplicatedNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean isEmpty() {
        return this.lottoNumbers.isEmpty();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    public int getCountOfMatchingNumber(LottoNumbers winningNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return this.lottoNumbers.containsAll(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        Collections.sort(this.lottoNumbers);
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            stringJoiner.add(lottoNumber.toString());
        }
        return "[" + stringJoiner.toString() + "]";
    }

    private void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또번호 개수가 부족하거나 초과하였습니다.");
        }
    }

    private void validateDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> result = new HashSet<>(lottoNumbers);
        if (result.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또는 중복되는 번호를 가질 수 없습니다.");
        }
    }
}
