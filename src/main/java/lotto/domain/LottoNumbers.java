package lotto.domain;

import lotto.exception.DuplicateLottoNumbersException;
import lotto.exception.IllegalLottoNumbersSizeException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.NUMBER_RANGE_FROM;
import static lotto.domain.LottoNumber.NUMBER_RANGE_TO;

public class LottoNumbers {

    public static final int NUMBER_INDEX_FROM = 0;
    public static final int NUMBER_INDEX_TO = 6;

    public static final int SIZE = NUMBER_INDEX_TO - NUMBER_INDEX_FROM;

    private static final List<Integer> ALL_LOTTO_NUMBERS = IntStream.rangeClosed(NUMBER_RANGE_FROM, NUMBER_RANGE_TO)
            .boxed()
            .collect(Collectors.toList());

    private final List<LottoNumber> numbers;


    public LottoNumbers() {
        this(autoNumbers());
    }

    public LottoNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);

        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Integer> autoNumbers() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return ALL_LOTTO_NUMBERS.subList(NUMBER_INDEX_FROM, NUMBER_INDEX_TO);
    }

    private void validateNumbersSize(List<Integer> numbers) throws IllegalLottoNumbersSizeException {
        if (notMatchSize(numbers)) {
            throw new IllegalLottoNumbersSizeException(SIZE, numbers.size());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) throws DuplicateLottoNumbersException {
        if (hasDuplicates(numbers)) {
            throw new DuplicateLottoNumbersException(numbers);
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }

    private boolean notMatchSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public Stream<LottoNumber> stream() {
        return this.numbers.stream();
    }

    public List<LottoNumber> get() {
        return this.numbers;
    }
}
