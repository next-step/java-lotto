package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lottery {
    List<Number> lottery;

    public Lottery(List<Number> randomNumbers) {
        this.lottery = randomNumbers.stream()
                .collect(Collectors.toList());
    }

    public List<Number> getLottery() {
        return lottery;
    }

    public int correctCount(Lottery correctNumbers) {
        return Long.valueOf(this.lottery.stream()
                .filter(n -> correctNumbers.getLottery().stream()
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
