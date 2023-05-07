package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchesNumber(Lotto lotto) {
        return lottoNumbers.stream()
                .filter(number -> lotto.contains(number))
                .collect(Collectors.toList())
                .size();
    }

    private boolean contains(LottoNumber number) {
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
