package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lottery {
    final List<Number> lottery;

    public static Lottery createFromArray(String[] numbers) {
        return new Lottery(Arrays.stream(numbers)
                .map(n -> Number.createFromString(n))
                .collect(Collectors.toList()));
    }

    public static Lottery createFromList(List<Number> numbers) {
        return new Lottery(numbers);
    }

    private Lottery(List<Number> randomNumbers) {
        this.lottery = new ArrayList<>(randomNumbers);
    }

    public List<Number> getList() {
        return lottery;
    }

    public int correctCount(Lottery correctNumbers) {
        return Long.valueOf(this.lottery.stream()
                .filter(n -> correctNumbers.getList().stream()
                        .anyMatch(Predicate.isEqual(n)))
                .count()).intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery1 = (Lottery) o;
        return Objects.equals(lottery, lottery1.lottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery);
    }
}
