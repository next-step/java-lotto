package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer countMatchNumbers(List<Integer> answerSheetNumbers) {
        return (int) answerSheetNumbers.stream().filter(numbers::contains).count();
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
