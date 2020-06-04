package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int COUNT_OF_NUMBERS = 6;
    public static final List<Integer> CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private final Set<Integer> numbers;

    public LottoNumbers(Set<Integer> numbers) {
        validate(numbers.size());
        this.numbers = Collections.unmodifiableSet(numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int size() {
        return numbers.size();
    }

    public long countMatches(int number) {
        return numbers.stream()
                .filter(n -> n == number)
                .count();
    }

    public long countMatches(WinningNumbers winningNumbers) {
        validate(winningNumbers.size());

        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void validate(int count) {
        if (count != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 일치하지 않습니다");
        }
    }
}
