package step2.domain.lotto;

import java.util.List;

public class MarkingNumbers {

    private final List<Integer> markingNumbers;

    public MarkingNumbers(List<Integer> markingNumbers) {
        this.markingNumbers = markingNumbers;
    }

    @Override
    public String toString() {
        return markingNumbers.toString();
    }

    public boolean contains(Integer number) {
        return markingNumbers.contains(number);
    }
}
