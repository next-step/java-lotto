package autolotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchCount(List<Integer> comparisonTarget) {
        Collections.sort(comparisonTarget);

        return (int) comparisonTarget.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public int size() {
        return this.numbers.size();
    }

}
