package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Lottery {
    final List<Number> lottery;

    public Lottery(List<Number> randomNumbers) {
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
