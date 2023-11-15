package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;
    public static final int NUMBER_COUNT = 6;

    private static final String NUMBER_COUNT_ERROR_MESSAGE = String.format("로또 번호는 총 %s자리 입니다", NUMBER_COUNT);
    private static final String NUMBER_ERROR_MESSAGE = String.format("로또 번호는 %s ~ %s 사이의 숫자이어야 합니다.", NUMBER_MIN, NUMBER_MAX);


    private final List<Integer> numbers;

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(validate(numbers));
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        validateCount(numbers);

        for (Integer number : numbers) {
            validateRange(number);
        }

        return numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateRange(Integer number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    public long match(LottoNumbers jackpot) {
        return jackpot.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
