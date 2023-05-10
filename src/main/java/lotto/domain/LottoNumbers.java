package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumberEmpty(lottoNumbers);
        validateLottoNumberLength(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingLottoNumber(LottoNumbers lottoNumbers) {
        Set<LottoNumber> aggregateOfLottoNumber = new HashSet<>(this.lottoNumbers);
        aggregateOfLottoNumber.retainAll(lottoNumbers.lottoNumbers);

        return aggregateOfLottoNumber.size();
    }

    public boolean isMatchingLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber::equals);
    }

    public void validateLottoNumberLength(List<LottoNumber> lottoNumbers) {

        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또번호는 6개 여야합니다 :(");
        }
    }

    public void validateLottoNumberEmpty(List<LottoNumber> lottoNumbers) {

        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("로또번호가 입력되지 않았어요 :(");
        }

        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("로또번호가 입력되지 않았어요 :(");
        }
    }

    public void validateLottoNumberLength(List<LottoNumber> lottoNumbers) {

        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또번호는 6개 여야합니다 :(");
        }
    }

    public void validateLottoNumberEmpty(List<LottoNumber> lottoNumbers) {

        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("로또번호가 입력되지 않았어요 :(");
        }

        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("로또번호가 입력되지 않았어요 :(");
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}

