package study.lotto.step2.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUMBER_OF_SELECT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::number)
                .collect(Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new), Collections::unmodifiableSet));
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != NUMBER_OF_SELECT) {
            throw new IllegalArgumentException("로또 번호 선택 갯수는 " + NUMBER_OF_SELECT + "개입니다: " + lottoNumbers.size());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
