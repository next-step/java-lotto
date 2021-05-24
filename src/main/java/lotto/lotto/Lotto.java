package lotto.lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.error.ErrorMessage;
import lotto.ui.Command;

public class Lotto {
    public static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers;

    public Lotto(int... numbers) {
        checkNumber(numbers);
        this.numbers = Stream.of(numbers)
                .flatMapToInt(Arrays::stream)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public boolean isSelectComplete() {
        return numbers.size() >= MAX_COUNT;
    }

    public void retainAll(Answer answer) {
        numbers.retainAll(answer.numbers());
    }

    public int answerCount() {
        return numbers.size();
    }

    public String numbersToString() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(Command.NUMBER_DELIMITER));
    }

    private void checkNumber(int[] numbers) {
        if (numbers.length != MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
    }
}
