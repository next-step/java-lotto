package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.number.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers.addAll(lottoGenerator.generate());
    }

    public int findMatchCount(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean hasBonusLottoNumber(LottoNumber bonusLottoNumber) {
        return lottoNumbers.contains(bonusLottoNumber);
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

    @Override
    public String toString() {
        return lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
