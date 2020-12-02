package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class NumberPool {

    protected static final int START_INCLUSIVE = 0;

    private static final List<LottoNumber> numberPool = makePool();

    private static List<LottoNumber> makePool() {
        return IntStream.range(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static Set<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numberPool);

        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = START_INCLUSIVE; i < LottoMachine.LOTTO_SIZE; i++) {
            numbers.add(numberPool.get(i));
        }

        return new HashSet<>(numbers);
    }
}
