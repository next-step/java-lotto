package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private NumberGenerator() {}

    public static List<Integer> generateBasicNumber(int startNumber, int endNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            numbers.add(i);
        }
        return numbers;
    }

}
