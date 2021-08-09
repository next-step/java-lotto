package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoLottoStrategy implements LottoStrategy{
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int NUMBER_CNT = 6;

    @Override
    public List<Integer> getLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            numbers.add(i);
        }

        long seed = System.nanoTime();
        Collections.shuffle(numbers, new Random(seed));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < NUMBER_CNT; i++) {
            result.add(numbers.get(i));
        }

        return result;
    }
}
