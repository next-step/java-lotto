package lotto.utils;

import lotto.model.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(1, 45)
                                                             .mapToObj(it -> new LottoNumber(it))
                                                             .collect(Collectors.toList());

    public Set<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new HashSet<>(LOTTO_NUMBERS.subList(0, 6));
    }
}
