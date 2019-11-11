package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String TO_STRING_FORMAT = "[%s]";
    private static final String NUMBERS_JOIN_DELIMITER = ", ";
    private static final int HASH_CODE_PRIME = 59;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.getLottoNumbers();
    }

    public int compare(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        String numberString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(NUMBERS_JOIN_DELIMITER));
        return String.format(TO_STRING_FORMAT, numberString);
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
        int hashCode = 1;
        for (LottoNumber lottoNumber : lottoNumbers) {
            hashCode = HASH_CODE_PRIME * hashCode + (lottoNumber == null ? 0 : lottoNumber.hashCode());
        }
        return hashCode;
    }
}
