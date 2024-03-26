package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer countMatchNumbers(List<Integer> answerSheetNumbers) {
        return (int) answerSheetNumbers.stream().filter(numbers::contains).count();
    }
    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }
    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
