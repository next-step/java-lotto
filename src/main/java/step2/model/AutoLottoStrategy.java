package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoLottoStrategy implements LottoStrategy{
    public AutoLottoStrategy() {
        for (int i = MIN; i <= MAX; i++) {
            numberList.add(i);
        }
    }

    @Override
    public List<Integer> getNumbers() {
        long seed = System.nanoTime();
        Collections.shuffle(numberList, new Random(seed));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            result.add(numberList.get(i));
        }

        return result;
    }
}
