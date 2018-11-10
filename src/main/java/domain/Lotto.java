package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int match(WinningNumber winningNumber) {
        return (int) numbers.stream()
            .filter(winningNumber::isContain)
            .count();
    }

    @Override
    public String toString() {
        return "[" +
            String.join(
                ", ",
                numbers.stream().map(String::valueOf).collect(Collectors.toList())) +
            "]";
    }
}
