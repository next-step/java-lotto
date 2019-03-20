package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int matchCount(Numbers target) {
        int matchCount = 0;
        for (int number : target.numbers) {
            matchCount += count(number);
        }
        return matchCount;
    }

    private int count(int number) {
        if (this.contains(number))
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return this.numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
