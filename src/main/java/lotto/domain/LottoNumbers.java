package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int TOTAL_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    LottoNumbers() {
        this.numbers = createRandomNumbers();
    }

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = createNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TOTAL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자들은 " + TOTAL_NUMBER_SIZE + "개로 구성되어야합니다.");
        }
    }

    private List<LottoNumber> createRandomNumbers() {
        return createNumbers(LottoGenerator.generateRandomNumbers());
    }

    private List<LottoNumber> createNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    int countMatchedNumbers(LottoNumbers winningLottoNumbers) {
        return (int) this.numbers.stream()
                .filter(winningLottoNumbers.numbers::contains)
                .count();
    }

    boolean isBonusMatched(LottoNumber bonusLottoNumber) {
        return this.numbers.stream()
                .anyMatch(number -> number.equals(bonusLottoNumber));
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }
}
