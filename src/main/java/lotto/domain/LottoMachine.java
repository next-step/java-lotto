package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private List<Integer> numbers;

    public LottoMachine() {
        settings();
    }

    private void settings() {
        numbers = new ArrayList<>();
        for (int idx = 1; idx <= 45; idx++) {
            numbers.add(idx);
        }
    }

    public List<Integer> raffle() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted().collect(Collectors.toList());
    }
}
