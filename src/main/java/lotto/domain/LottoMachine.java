package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final List<Integer> numbers;

    static {
        numbers = new ArrayList<>();
        for (int idx = LOTTO_MIN_NUMBER; idx <= LOTTO_MAX_NUMBER; idx++) {
            numbers.add(idx);
        }
    }

    public static List<Integer> raffle() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted().collect(Collectors.toList());
    }
}
