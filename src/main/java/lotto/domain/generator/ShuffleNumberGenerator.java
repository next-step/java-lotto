package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleNumberGenerator implements LottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_SIZE);
    }
}
