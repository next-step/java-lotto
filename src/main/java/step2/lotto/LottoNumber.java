package step2.lotto;

import step2.lotto.exception.InvalidLottoNumberException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN_BOUND = 1;
    private static final int LOTTO_NUMBER_MAX_BOUND = 45;
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public Stream<Integer> stream() {
        return this.numbers.stream();
    }

    public long countOfMatches(LottoNumber lottoNumber) {
        return lottoNumber.stream()
                .filter(this.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateNumber(List<Integer> numbers) {
        Function<Integer, Boolean> validateFunction = value -> value <= LOTTO_NUMBER_MAX_BOUND && value >= LOTTO_NUMBER_MIN_BOUND;
        boolean valid = numbers.stream()
                .allMatch(validateFunction::apply);

        if(!valid)
            throw new InvalidLottoNumberException("로또 넘버는 1~45 사이여야 합니다");
    }
}
