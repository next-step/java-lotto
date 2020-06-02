package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final List<Integer> numbers;

    static {
        numbers = new ArrayList<>();
        for (int idx = 1; idx <= 45; idx++) {
            numbers.add(idx);
        }
    }

    public LottoMachine() {
    }

    public List<Integer> raffle() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted().collect(Collectors.toList());
    }
}
