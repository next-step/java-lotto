package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class LottoNumber {
    public static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자만 입력할 수 있습니다.";
    public static final String INVALID_LOTTO_NUMBER_SIZE = "로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.";
    public static final String LOTTO_NUMBER_CANT_DUPLICATE = "로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    private LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumber from(List<Integer> numbers) {
        validLottoNumberSize(numbers);
        validLottoNumberBound(numbers);
        validLottoNumberDuplicate(numbers);

        return new LottoNumber(numbers);
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

    private static void validLottoNumberDuplicate(List<Integer> numbers) {
        int originalSize = numbers.size();
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();

        if (originalSize != distinctCount) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CANT_DUPLICATE);
        }
    }

    private static void validLottoNumberBound(List<Integer> numbers) {
        boolean isInvalid = numbers.stream()
                .anyMatch((number) -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);

        if (isInvalid) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }
    }

    private static void validLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
