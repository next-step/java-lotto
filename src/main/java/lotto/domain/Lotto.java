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

    /*
    * 로또 번호들 중에서 일치하는 수를 반환한다.
    * */
    public int contains(LottoNumbers checkNumbers) {
        return this.numbers.containsAll(checkNumbers);
    }

    /*
    * 로또 번호 하나(보너스볼)와 일치하는 것이 있는지 확인한다.
    * */
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
