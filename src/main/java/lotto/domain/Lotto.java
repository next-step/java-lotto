/*
* 로또번호 집합을 보유하는 하나의 로또 클래스
* */
package lotto.domain;

import java.util.Objects;

public class Lotto {

    private LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int contains(LottoNumbers checkNumbers) {
        return this.numbers.containsAll(checkNumbers);
    }

    public boolean containsBouns(LottoNumber checkNumber) {
        if (checkNumber == null) {
            return false;
        }
        return numbers.containsOne(checkNumber);
    }

    public LottoNumbers numbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
