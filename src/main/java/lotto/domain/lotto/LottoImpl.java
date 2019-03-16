package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoImpl implements Lotto {
    private int matchCount = 0;
    private List<Integer> numbers;

    public LottoImpl(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchCountUp() {
        return ++this.matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
