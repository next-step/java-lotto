package lotto.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 01:05
 */
public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개로 이루어져야 합니다.");
        }

        if (lottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복이 불가능 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
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
