package lotto.domain.number;

import lotto.domain.number.generator.NumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    public final static int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers newLottoNumbersWithNumberGenerator(NumberGenerator<LottoNumber> generator) {
        return new LottoNumbers(createLottoNumbers(generator));
    }

    public static LottoNumbers newLottoNumbersWithList(List<Integer> numbers) {
        return new LottoNumbers(createLottoNumbersThroughInteger(numbers));
    }

    private static List<LottoNumber> createLottoNumbersThroughInteger(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> createLottoNumbers(NumberGenerator<LottoNumber> generator) {
        return generator.getNumbers();
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        validateLottoNumbersLength(numbers);
        validateLottoNumberDuplicate(numbers);
    }

    private void validateLottoNumbersLength(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoNumbersLengthException();
        }
    }

    private void validateLottoNumberDuplicate(List<LottoNumber> numbers) {
        int distinctCount = Math.toIntExact(numbers.stream()
                .map(LottoNumber::getNumber)
                .distinct()
                .count()
        );

        if (distinctCount != LOTTO_SIZE) {
            throw new LottoNumbersDuplicateException();
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int matchCount(LottoNumber bonusLottoNumber) {
        return Math.toIntExact(
                this.numbers.stream()
                .filter(lottoNumber -> lottoNumber.equals(bonusLottoNumber))
                .count()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
