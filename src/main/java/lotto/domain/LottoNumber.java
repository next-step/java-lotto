package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoValidator.*;

public class LottoNumber {
    public static final String INVALID_LOTTO_NUMBER_SIZE = "로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.";
    public static final String LOTTO_NUMBER_CANT_DUPLICATE = "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자만 입력할 수 있습니다.";

    private final List<MyNumber> numbers;

    private LottoNumber(List<MyNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumber from(List<Integer> numbers) {
        valid(numbers);

        List<MyNumber> myNumbers = new ArrayList<>();
        for (int number : numbers) {
            myNumbers.add(MyNumber.valueOf(number));
        }

        return new LottoNumber(myNumbers);
    }

    private static void valid(List<Integer> numbers) {
        if (isInvalidLottoNumberSize(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }

        if (isInvalidLottoNumberBound(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }

        if (isLottoNumberDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CANT_DUPLICATE);
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

    public boolean isContainNumber(MyNumber myNumber) {
        return numbers.contains(myNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
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
