package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.MAX_NUMBER;

public class LottoNumberPool {

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
