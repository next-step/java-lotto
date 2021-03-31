/*
* 로또번호 집합을 보유하는 일급 컬렉션
* */
package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static lotto.util.Message.ILLEGAL_LOTTO_SIZE;

public class LottoNumbers {
    public static int LOTTO_SIZE = 6;

    private Set<LottoNumber> lottoNumberSet = new LinkedHashSet<>();

    public LottoNumbers(Set<LottoNumber> lottoNumberSet) {
        if(hasLottoSize(lottoNumberSet)) {
            this.lottoNumberSet = lottoNumberSet;
        }
    }

    public boolean hasLottoSize(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_SIZE);
        }
        return true;
    }


    public int containsAll(LottoNumbers checkNumbers) {
        return Long.valueOf(checkNumbers.lottoNumberSet.stream()
                .filter(checkNumber -> this.lottoNumberSet.contains(checkNumber))
                .count())
                .intValue();
    }

    public boolean containsOne(LottoNumber checkNumber) {
        return lottoNumberSet.contains(checkNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumberSet, that.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }



}
