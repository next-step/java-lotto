package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

    final static int LOTTO_NUMBER_SIZE = 6;
    private final List<Number> numbers;

    public LottoNumbers(List<Number> numbers) {
        verifySize(numbers);
        verifyDuplicationNumber(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public long matchCount(LottoNumbers targetNumbers) {
        return this.numbers.stream()
                .filter(targetNumbers::contains)
                .count();
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    private void verifySize(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("6개의 숫자만 입력해야 합니다.");
        }
    }

    private void verifyDuplicationNumber(List<Number> numbers) {
        HashSet<Number> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

}
