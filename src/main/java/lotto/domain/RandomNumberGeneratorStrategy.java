package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy{

    public static final List<LottoNumber> NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public Set<LottoNumber> generateNumbers() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
