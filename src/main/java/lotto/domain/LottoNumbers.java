package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;
    public static final int NUMBER_LEN = 6;

    public LottoNumbers(NumberGenerator lottoNumbersGenerator) {
        this(lottoNumbersGenerator.generateNumbers());
    }

    public LottoNumbers(LottoNumbers lottoNumbers) {
        this.numbers = lottoNumbers.numbers;
    }

    public LottoNumbers(List<Integer> inputNumbers) {
        List<LottoNumber> numbers = inputNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertValidLength(numbers);
        assertNotDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isContainNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int matchCount(LottoNumbers lottoNumbers) {

        return (int) this.numbers.stream()
                .filter(lottoNumbers.numbers::contains)
                .count();
    }

    private void assertValidLength(List<LottoNumber> numbers) {
        String errorMessage = "[로또] 숫자 6개를 입력해주세요.";

        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (numbers.size() != NUMBER_LEN) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void assertNotDuplicateNumber(List<LottoNumber> numbers) {
        String errorMessage = "[로또] 중복된 숫자를 입력했습니다.";
        Set<LottoNumber> uniqueNumbers = Set.copyOf(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }


}
