package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy{

    @Override
    public Set<LottoNumber> generateNumbers() {
        Collections.shuffle(LottoNumber.NUMBERS);
        return LottoNumber.NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
