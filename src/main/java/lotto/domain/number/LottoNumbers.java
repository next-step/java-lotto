package lotto.domain.number;

import lotto.exception.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final int LOTTO_NUMBER_SIZE = 6;

    private Set<LottoNumber> numbers;

    private LottoNumbers() {
    }

    private LottoNumbers(final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = new LinkedHashSet<>(numbers);
    }

    public static LottoNumbers autoCreate() {
        return new LottoNumbers(LottoNumbersGenerator.generate());
    }

    public static LottoNumbers manualCreate(final String numbers) {
        validateNumbers(numbers);
        return new LottoNumbers(Arrays.stream(numbers.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private void validateNumbers(final List<LottoNumber> numbers) {
        if ((numbers == null) || (numbers.size() != LOTTO_NUMBER_SIZE)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.REQUIRED_SIZE_OF_LOTTO_NUMBERS, LOTTO_NUMBER_SIZE));
        }
        checkDuplication(numbers);
    }

    private static void validateNumbers(final String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    private void checkDuplication(final List<LottoNumber> numbers) {
        Set<LottoNumber> numbersOfNotDuplicated = new HashSet<>(numbers);

        if (numbersOfNotDuplicated.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS);
        }
    }

    public int matchCount(final LottoNumbers winningLottoNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningLottoNumbers::contains)
                .count());
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public List<Integer> getNumbersAsInt() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
