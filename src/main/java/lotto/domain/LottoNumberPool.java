package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberPool {

    private static final int MAX_NUMBER = 45;
    private static final List<Integer> numbers = new ArrayList<>();

    public static List<Integer> getNumbers() {
        if (numbers.isEmpty()) {
            for (int i = 1; i <= MAX_NUMBER; i++) {
                numbers.add(i);
            }
        }

        return numbers;
    }
}
