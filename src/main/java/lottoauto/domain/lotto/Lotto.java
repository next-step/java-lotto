package lottoauto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }


    public int getLottoScore(List<Integer> winnerNumbers) {
        int result = 0;

        for (Integer winnerNumber : winnerNumbers) {
            result = numbers.match(result, winnerNumber);
        }

        return result;
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
