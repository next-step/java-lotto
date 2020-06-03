package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy{

    @Override
    public List<Integer> generateNumbers() {
        Collections.shuffle(Lotto.NUMBERS);
        return Lotto.NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toList());
    }
}
