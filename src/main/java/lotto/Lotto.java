package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<Number> numbers;

    //FIXME: 중복이 없는 자료 구조형 사용, 정렬을 위해서 TreeSet 이용 검토
    public Lotto(List<Number> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto print(final LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.provideNumberSet());
    }

    public Rank checkRank(List<Number> winnersNumber) {
        return Rank.valueOf(match(winnersNumber));
    }

    private int match(List<Number> winnersNumber) {
        List<Number> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(winnersNumber);
        return numbers.size();
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
