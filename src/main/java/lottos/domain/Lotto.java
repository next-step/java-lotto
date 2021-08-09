package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import lottos.domain.numbers.Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String NUMBERS_TEXT_SPLIT_REGEX = ",";

    private final Numbers numbers;

    public Lotto(final String numbersText) {
        this(parseTextToNumbers(numbersText));
    }

    public Lotto(final List<Integer> numbers) {
        this.numbers = Numbers.from(numbers);
    }

    public Lotto(final Numbers numbers) {
        this.numbers = numbers;
    }

    private static List<Integer> parseTextToNumbers(final String numbersText) {
        if (numbersText == null || numbersText.isEmpty()) {
            throw new LottoSizeIncorrectException();
        }
        return Arrays.stream(numbersText.split(NUMBERS_TEXT_SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
