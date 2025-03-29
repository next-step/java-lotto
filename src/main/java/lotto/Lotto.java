package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersRange(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public Lotto(LottoNumberGenerator generator) {
        this(generator.generate());
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
    }

    public int countMatchWith(Lotto other) {
        return (int) numbers.stream()
            .filter(other.getNumbers()::contains)
            .count();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
