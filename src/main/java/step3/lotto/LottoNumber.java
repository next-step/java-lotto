package step3.lotto;

import step3.lotto.exception.InvalidLottoNumberException;

import java.util.Collections;
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

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    private void validateNumber(List<Integer> numbers) {
        Function<Integer, Boolean> boundaryValidateFunction = value -> value <= LOTTO_NUMBER_MAX_BOUND && value >= LOTTO_NUMBER_MIN_BOUND;
        boolean outOfBoundary = numbers.stream()
                .anyMatch(number -> !boundaryValidateFunction.apply(number));

        if(outOfBoundary)
            throw new InvalidLottoNumberException("로또 넘버는 1~45 사이여야 합니다");

        boolean existDuplicatedNumber = numbers.stream()
                .anyMatch(number -> Collections.frequency(numbers, number) > 1);

        if(existDuplicatedNumber)
            throw new InvalidLottoNumberException("로또 넘버 사이에 중복이 발생할 수 없습니다");
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
