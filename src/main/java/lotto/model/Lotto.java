package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final Random RANDOM = new Random();
    private static final Integer MAX_LOTTO_BOUND = 44;
    private static final Integer NUMBER_COUNT = 6;
    List<Integer> numbers;

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            numbers.add(RANDOM.nextInt(MAX_LOTTO_BOUND));
        }
        this.numbers = numbers;
    }
}
