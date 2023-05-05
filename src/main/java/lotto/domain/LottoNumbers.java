package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingLottoNumber(LottoNumbers lottoNumbers) {
        return findMatchingLottoNumber(lottoNumbers).size();
    }

    private List<LottoNumber> filterMatchingLottoNumber(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream()
                .filter(this::isMatchingLottoNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoNumber> findMatchingLottoNumber(LottoNumbers targetLottoNumbers) {
        return targetLottoNumbers.filterMatchingLottoNumber(this.lottoNumbers);
    }

    public boolean isMatchingLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber::isSameLottoNumber);
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

