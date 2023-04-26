package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_NUMBERS_MAX_COUNT = 6;

    private final List<Integer> numbers;

    public LottoNumbers(Integer... numbers) {
        this(List.of(numbers));
    }

    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        numbers.forEach(LottoNumbers::validateRange);
    }

    private static void validateRange(Integer number) {
        if (number < LOTTO_NUMBER_MINIMUM || number > LOTTO_NUMBER_MAXIMUM) {
            String msg = String.format("로또 숫자의 범위는 %d ~ %d 입니다.", LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
            throw new IllegalArgumentException(msg);
        }
    }

    public static LottoNumbers generate() {
        List<Integer> rangedNumbers = IntStream.range(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM + 1)
                .boxed()
                .collect(toList());
        Collections.shuffle(rangedNumbers);
        List<Integer> subNumbers = rangedNumbers.subList(0, LOTTO_NUMBERS_MAX_COUNT);
        Collections.sort(subNumbers);
        return new LottoNumbers(subNumbers);
    }

    public long matchCount(LottoWinningNumber lottoWinningNumber) {
        return numbers.stream()
                .filter(lottoWinningNumber::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}