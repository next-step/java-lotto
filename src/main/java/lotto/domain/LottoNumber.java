package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.LottoConstants.*;

public class LottoNumber {
    private final List<Integer> numbers;

    private LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumber from(List<Integer> numbers) {
        validLottoNumberSize(numbers);
        validLottoNumberBound(numbers);

        return new LottoNumber(numbers);
    }

    private static void validLottoNumberBound(List<Integer> numbers) {
        boolean isInvalid = numbers.stream()
                .anyMatch((number) -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);

        if (isInvalid) {
            throw new IllegalArgumentException();
        }
    }

    private static void validLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return numbers.size();
    }

    public int containsCount(LottoNumber lottoNumber) {
        return (int) lottoNumber.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public String getNumbersToString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
