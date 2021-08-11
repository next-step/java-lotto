package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoLottoStrategy implements LottoStrategy{
    public AutoLottoStrategy() {
        for (int i = MIN; i <= MAX; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Integer> getNumbers() {
        long seed = System.nanoTime();
        Collections.shuffle(numbers, new Random(seed));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < NUMBER_CNT; i++) {
            result.add(numbers.get(i));
        }

        return result;
    }
}
