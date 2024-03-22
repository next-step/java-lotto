package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 50).boxed().collect(Collectors.toList());
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        numbers = LOTTO_NUMBERS.stream().limit(LOTTO_NUMBER_COUNT).sorted().collect(Collectors.toList());
    }

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
