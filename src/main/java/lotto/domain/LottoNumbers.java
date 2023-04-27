package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableSet;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_MAX_COUNT = 6;

    private final List<LottoNumber> numbers;

    public static LottoNumbers ofTypeIntegers(Integer... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(toUnmodifiableList());
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers ofTypeIntegerList(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toUnmodifiableList());
        return new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        validateDuplicatedNumbers(numbers);
        validateNumbersCount(numbers);
    }

    private void validateDuplicatedNumbers(List<LottoNumber> numbers) {
        Set<Integer> numberSet = numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(toUnmodifiableSet());
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 포함되어있습니다.");
        }
    }

    private void validateNumbersCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_MAX_COUNT) {
            throw new IllegalArgumentException("로또 숫자입력이 올바르지 않습니다.(유효한 개수: 6개)");
        }
    }

    public long countToMatchedWinnerNumbers(LottoNumbers winnerNumbers) {
        return numbers.stream()
                .filter(winnerNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}