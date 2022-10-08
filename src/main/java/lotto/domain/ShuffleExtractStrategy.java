package lotto.domain;

import java.util.Collections;
import java.util.List;

public class ShuffleExtractStrategy extends ExtractStrategy {

    @Override
    public List<Integer> extractNumber(int number) {
        Collections.shuffle(baseNumbers);
        return baseNumbers.subList(0, number);
    }
}
