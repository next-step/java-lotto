package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.number.LottoNumber;

import java.util.*;

public class Lotto {
    private final HashSet<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers.addAll(lottoGenerator.generate());
    }

    public int findMatchCount(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningLotto.winningLotto.contains(lottoNumber))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashSet)) return false;
        return Objects.equals(this.lottoNumbers, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
