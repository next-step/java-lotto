package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandom {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int SIZE = 6;

    private final List<Integer> numbers;

    public LottoRandom() {
        numbers = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> getRandomNumber() {
        Collections.shuffle(numbers);

        return numbers.stream().limit(SIZE).sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
}
