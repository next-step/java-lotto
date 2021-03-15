package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    List<Integer> numbers;

    public Lotto() {
    }

    public Lotto(List<Integer> givenLottoNumbers) {
        this.numbers = givenLottoNumbers;
        Collections.sort(this.numbers);
    }

    public int matches(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
        long numberOfMatches = winningNumbers.stream()
                .filter(winningNumber -> numbers.contains(winningNumber))
                .count();
        return (int) numberOfMatches;
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
