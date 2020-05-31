package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int COUNT_OF_NUMBERS = 6;
    public static final List<Integer> CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private Set<Integer> numbers;

    public Lotto(LottoNumberSelectRule numberSelectRule) {
        this.numbers = Collections.unmodifiableSet(numberSelectRule.select());
        validateCount(this.numbers.size());
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Rank checkResult(WinningNumbers winningNumbers) {
        validateCount(winningNumbers.size());

        long matchedCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return Rank.findByMatchedCount(matchedCount);
    }

    private void validateCount(int count) {
        if (count != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 일치하지 않습니다");
        }
    }
}
