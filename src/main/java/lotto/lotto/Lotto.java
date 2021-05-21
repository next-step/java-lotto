package lotto.lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private static final int MAX_COUNT = 6;
    private final Set<Integer> numbers = new HashSet<>();

    public void addNumber(int number) {
        if (!isContain(number)) {
            numbers.add(number);
        }
    }

    public boolean isSelectComplete() {
        return numbers.size() >= MAX_COUNT;
    }

    private boolean isContain(int number) {
        return numbers.contains(number);
    }
}
