package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoStrategy implements LottoStrategy{

    public static final int LOTTO_NUM_MIN = 0;
    public static final int LOTTO_NUM_MAX = 45;

    @Override
    public List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = LOTTO_NUM_MIN; i < LOTTO_NUM_MAX; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> result = numbers.subList(0, 6);
        Collections.sort(result);

        return result;
    }
}
