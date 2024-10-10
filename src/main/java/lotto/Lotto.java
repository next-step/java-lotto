package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int TOTAL_PER_LOTTO = 6;
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private final Random random;

    public Lotto() {
        this.random = new Random();
    }

    public Lotto(long seed) {
        this.random = new Random(seed);
    }

    public List<Integer> create() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < TOTAL_PER_LOTTO; i++) {
            result.add(pick());
        }
        return result;
    }

    private int pick() {
        return this.random.nextInt(MAX_NUMBER_OF_LOTTO) + 1;
    }

}
