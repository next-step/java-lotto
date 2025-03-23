package lotto.model.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {

    private static final List<Integer> BASE_NUMBERS;

    static {
        BASE_NUMBERS = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            BASE_NUMBERS.add(i);
        }
    }

    @Override
    public int generate(int maxNumber) {
        List<Integer> shuffledNumbers = new ArrayList<>(BASE_NUMBERS.subList(0, maxNumber));
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.get(0);
    }
}
