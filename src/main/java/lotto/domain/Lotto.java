package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private static final String LOTTO_NUMBERS_INVALID_SIZE_ERROR_MESSAGE = "로또 번호의 개수는 6개가 들어와야 한다.";
    private static final String LOTTO_NUMBERS_INVALID_DUPLICATE_ERROR_MESSAGE = "로또의 번호는 중복되어 저장될 수 없다.";

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkLottoNumbersSize(numbers);
        checkDuplicatedNumber(numbers);

        numbersSortByAsc(numbers);
        this.numbers = numbers;
    }

    private static void checkLottoNumbersSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicatedNumber(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void numbersSortByAsc(List<LottoNumber> numbers) {
        Collections.sort(numbers);
    }

    public int calculateWinCount(Lotto winLotto) {
        return (int) winLotto.numbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public String printLotto() {
        return numbers.stream()
            .map(LottoNumber::value)
            .collect(Collectors.toList()).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
