package study.lotto.step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int NUMBER_OF_SELECT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Integer... lottoNumbers) {
        this(of(lottoNumbers));
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new), Collections::unmodifiableSet));
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != NUMBER_OF_SELECT) {
            throw new IllegalArgumentException("로또 번호 선택 갯수는 " + NUMBER_OF_SELECT + "개입니다: " + lottoNumbers.size());
        }
    }

    private static Set<LottoNumber> of(Integer...lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
