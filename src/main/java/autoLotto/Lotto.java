package autoLotto;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private Set<Integer> number;

    public Lotto(Set<Integer> number) {
        this.number = number;
    }

    public int countCommonNumbers(WinningLotto winningLotto) {
        return (int) number.stream()
                           .filter(winningLotto.getNumbers()::contains)
                           .count();
    }

    @Override
    public String toString() {
        String result = number.stream()
                              .sorted()
                              .map(String::valueOf)
                              .collect(Collectors.joining(", "));
        return String.format("[%s]", result);
    }
}
