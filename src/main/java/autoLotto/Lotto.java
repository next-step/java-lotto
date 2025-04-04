package autoLotto;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchedNumberCount(Lotto winningLotto) {
        return (int) numbers.stream()
                            .filter(winningLotto::containsNumber)
                            .count();
    }

    private boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("The number of Lotto numbers must be 6.");
        }
    }

    @Override
    public String toString() {
        String result = numbers.stream()
                               .sorted()
                               .map(String::valueOf)
                               .collect(Collectors.joining(", "));
        return String.format("[%s]", result);
    }
}
