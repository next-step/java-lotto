package lotto.model.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {

    public int generate(int maxNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.get(0);
    }
}
