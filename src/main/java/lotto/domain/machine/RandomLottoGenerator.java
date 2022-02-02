package lotto.domain.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int FIRST_COUNT = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> get() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(FIRST_COUNT, LOTTO_NUMBER_COUNT));
    }
}
