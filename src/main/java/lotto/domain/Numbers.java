package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final int LOTTO_RANGE = 45;
    private static final int START_NUMBER = 1;
    private static final int MARKED_RANGE = 6;

    private List<Integer> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
        for (int i = START_NUMBER; i <= LOTTO_RANGE; i++) {
            numbers.add(i);
        }
    }

    public void marked() {
        Collections.shuffle(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers.stream()
                .limit(MARKED_RANGE)
                .collect(Collectors.toList());
    }


}
