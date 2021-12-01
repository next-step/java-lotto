package lotto.game;

import java.util.List;

public class Game {
    private final List<Integer> numbers;

    public Game(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6자리 숫자만을 선택할 수 있습니다.");
        }
        numbers.forEach(this::validateNumber);
    }

    private void validateNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("로또는 1부터 45까지의 숫자만을 선택할 수 있습니다.");
        }
    }

    public Rank win(List<Integer> numbers) {
        validateNumbers(numbers);
        int count = countMatch(numbers);
        return Rank.of(count);
    }

    private int countMatch(List<Integer> numbers) {
        long count = numbers.stream()
                .map(this.numbers::contains)
                .filter(contain -> contain)
                .count();
        return Long.valueOf(count).intValue();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
