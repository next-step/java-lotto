package step4.domain;


import step4.exception.IllegalLottoException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        lottoSizeValidation(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void lottoSizeValidation(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalLottoException("정상적인 LOTTO SIZE가 아닙니다.");
        }
    }

    public static Lotto of(String lottoNumbers) {
        Set<LottoNumber> lotto = Arrays.stream(lottoNumbers.split(","))
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return new Lotto(lotto);
    }

    public boolean isContains(LottoNumber compareLottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(compareLottoNumber::equals);
    }

    public int matchNumberCounts (Lotto compareLotto) {
        long count = this.lottoNumbers.stream()
                .filter(compareLotto::isContains)
                .count();

        return (int)count;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;

        Lotto lotto = (Lotto) o;

        return lottoNumbers != null ? lottoNumbers.equals(lotto.lottoNumbers) : lotto.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}
