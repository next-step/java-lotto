package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoFactory.LOTTO_NUMBER;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("개수가 6개가 아닙니다.");
        }
    }

    public int getMatchingNumberCount(Lotto lotto) {
        return lottoNumbers.stream()
                .filter(number -> lotto.contains(number))
                .collect(Collectors.toList())
                .size();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "[","]"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
