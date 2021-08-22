package step4.lotto;

import step4.lotto.exception.ExceptionMessage;
import step4.lotto.exception.InvalidLottoNumberException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNo> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateNumber(numbers);
        this.numbers = numbers.stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

    public Stream<LottoNo> stream() {
        return this.numbers.stream();
    }

    public boolean contains(LottoNo number) {
        return numbers.contains(number);
    }

    private void validateNumber(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE)
            throw new InvalidLottoNumberException(ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE);
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        boolean existDuplicatedNumber = numbers.stream()
                .anyMatch(number -> Collections.frequency(numbers, number) > 1);

        if (existDuplicatedNumber)
            throw new InvalidLottoNumberException(ExceptionMessage.NUMBER_DUPLICATED);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
