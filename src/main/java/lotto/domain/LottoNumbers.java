package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 정확히 %s개여야 합니다.", LOTTO_NUMBER_COUNT));
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호에 중복된 값이 있습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(LottoNumbers winningNumbers) {
        return (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    private boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
