package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int TOTAL_SIZE_OF_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    LottoNumbers() {
        this.numbers = generatedRandomNumbers();
    }

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = generatedNumbers(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int matchedCount(List<Integer> matchNumbers) {
        return (int) numbers.stream()
                .map(LottoNumber::getNumber)
                .filter(matchNumbers::contains)
                .count();
    }

    public boolean matchBonus(LottoNumber bonusLottoNumber) {
        return numbers.stream()
                .anyMatch(n -> n.equals(bonusLottoNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    private List<LottoNumber> generatedRandomNumbers() {
        return generatedNumbers(LottoGenerator.generateSortedNumbers(TOTAL_SIZE_OF_NUMBERS));
    }

    private List<LottoNumber> generatedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers가 null이 전달되었습니다.");
        }
        if (numbers.size() != TOTAL_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자들은 " + TOTAL_SIZE_OF_NUMBERS + "개로 구성되어야합니다.");
        }
    }
}
