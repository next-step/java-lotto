package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
                                     .map(LottoNumber::new)
                                     .collect(Collectors.toList()));
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getValue() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getMatchNumberCount(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::hasNumber)
                .count();
    }

    public boolean hasNumber(LottoNumber value) {
        return this.lottoNumbers.contains(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
