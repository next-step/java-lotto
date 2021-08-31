package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private static final String LOTTO_NUMBERS_INVALID_SIZE_ERROR_MESSAGE = "로또 번호의 개수는 6개가 들어와야 한다.";
    private static final String LOTTO_NUMBERS_INVALID_DUPLICATE_ERROR_MESSAGE = "로또의 번호는 중복되어 저장될 수 없다.";
    private static final String LOTTO_NUMBERS_INVALID_ASC_ERROR_MESSAGE = "로또 번호는 오름차순으로 입력되어있어야 한다.";

    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        checkLottoNumbersSize(numbers);
        checkDuplicatedNumber(numbers);
        checkNumberAcs(numbers);

        this.numbers = numbers;
    }

    private static void checkLottoNumbersSize(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicatedNumber(List<Number> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void checkNumberAcs(List<Number> numbers) {
        List<Number> compare = new ArrayList<>(numbers);
        Collections.sort(compare);
        if (!numbers.equals(compare)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_ASC_ERROR_MESSAGE);
        }
    }

    public int calculateWinCount(Lotto winLotto) {
        return (int) winLotto.numbers.stream()
            .filter(numbers::contains)
            .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
