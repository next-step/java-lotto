package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int compare(Lotto other) {
        int count = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            if (other.contains(lottoNumber)) {
                count++;
            }
        }

        return count;
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        String numberString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
        return String.format("[%s]", numberString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int hashCode = 1;
        for (LottoNumber lottoNumber : lottoNumbers) {
            hashCode = prime * hashCode + (lottoNumber == null ? 0 : lottoNumber.hashCode());
        }
        return hashCode;
    }
}
