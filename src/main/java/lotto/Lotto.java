package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto print(final LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.provideNumberSet());
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

    public Division checkDivision(List<Number> winnersNumber) {
        int match = 0;
        for (Number number : winnersNumber) {
            if(numbers.contains(number)){
                match++;
            }
        }
        return Division.valueOf(match);
    }
}
