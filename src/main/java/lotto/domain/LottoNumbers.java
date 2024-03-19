package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private final List<Integer> numbers;

    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int NUMBER_LEN = 6;

    public LottoNumbers(NumberGenerator lottoNumbersGenerator) {
        this(lottoNumbersGenerator.generateNumbers());
    }

    public LottoNumbers(LottoNumbers lottoNumbers) {
        this(lottoNumbers.numbers);
    }

    private LottoNumbers(List<Integer> numbers) {
        assertValidLength(numbers);
        assertValidRange(numbers);
        assertNotDuplicateNumber(numbers);

        this.numbers = List.copyOf(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int matchCount(LottoNumbers lottoNumbers) {

        return (int) this.numbers.stream()
                .filter(lottoNumbers.numbers::contains)
                .count();
    }

    private void assertValidLength(List<Integer> numbers) {
        String errorMessage = "[로또] 숫자 6개를 입력해주세요.";

        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (numbers.size() != NUMBER_LEN) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void assertNotDuplicateNumber(List<Integer> numbers) {
        String errorMessage = "[로또] 중복된 숫자를 입력했습니다.";
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void assertValidRange(List<Integer> numbers) {
        String errorMessage = String.format("[로또] 숫자의 범위는 %d 부터 %d까지 입니다.", MIN_NUMBER, MAX_NUMBER);

        numbers.stream().filter(number -> MIN_NUMBER > number || number > MAX_NUMBER)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(errorMessage);
                });
    }
}
