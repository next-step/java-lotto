package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COUNT_OF_LOTTO = 6;
    private static final String NUMBERS_TEXT_SPLIT_REGEX = ",";
    private List<Integer> numbers;

    public Lotto(final String numbersText) {
        this(parseTextToNumbers(numbersText));
    }

    public Lotto(final List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new LottoSizeIncorrectException();
        }
        this.numbers = numbers;
    }

    private static List<Integer> parseTextToNumbers(final String numberText) {
        if (numberText == null || numberText.isEmpty()) {
            throw new LottoSizeIncorrectException();
        }
        return Arrays.stream(numberText.split(NUMBERS_TEXT_SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoResult match(final Lotto winningLotto) {
        int countOfMatchers = (int) (winningLotto.elements()
                .stream()
                .filter(numbers::contains)
                .count());
        return new LottoResult(Prize.findByNumberOfMatchers(countOfMatchers));
    }

    public List<Integer> elements() {
        return Collections.unmodifiableList(numbers);
    }
}
