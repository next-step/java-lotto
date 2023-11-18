package step2.model;

import java.util.List;

public class Lotto {

    private static final int MAX_LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("로또 번호가 없습니다.");
        }

        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개가 되어야 합니다.");
        }
    }

    public int getLottoWinner(List<Integer> winNumbers) {
        return (int) winNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
