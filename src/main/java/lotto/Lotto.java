package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            numbers.add(random.nextInt(45) + 1);
        }
        validateNumbersRange();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateNumbersRange();
    }

    private void validateNumbersRange() {
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
