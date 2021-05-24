package lotto.lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.error.ErrorMessage;
import lotto.ui.InputView;

public class Lotto {
    public static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers;

    public Lotto(int[] numbers) {
        checkNumber(numbers);
        this.numbers = Stream.of(numbers)
                .flatMapToInt(Arrays::stream)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public boolean isSelectComplete() {
        return numbers.size() >= MAX_COUNT;
    }

    public void retainAll(WinningNumber winningNumber) {
        numbers.retainAll(winningNumber.numbers());
    }

    public int answerCount() {
        return numbers.size();
    }

    public String numbersToString() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(InputView.NUMBER_DELIMITER));
    }

    public boolean isContainBonus(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void checkNumber(int[] numbers) {
        if (numbers.length != MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
    }
}
