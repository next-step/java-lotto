/*
* 로또번호 집합을 보유하는 하나의 로또 클래스
* */
package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int contains(List<LottoNumber> numbers) {
        return Long.valueOf(numbers.stream()
                .filter(number -> this.numbers.contains(number))
                .count())
                .intValue();
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(new ArrayList<>(numbers));
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
