package lotto.domain.number;

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

    public static LottoNumbers autoLottoNumber(List<LottoNumber> autoLottoNumbers) {
        return new LottoNumbers(autoLottoNumbers);
    }

    public static LottoNumbers manualLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
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
