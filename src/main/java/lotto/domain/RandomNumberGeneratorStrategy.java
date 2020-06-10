package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy{

    @Override
    public Set<Integer> generateNumbers() {
        Collections.shuffle(Lotto.NUMBERS);
        return Lotto.NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
