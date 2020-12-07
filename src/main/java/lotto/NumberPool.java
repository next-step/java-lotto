package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public final class NumberPool {

    private static final int START_INCLUSIVE = 0;

    private static final List<LottoNumber> numberPool = makePool();

    private NumberPool() {}

    private static List<LottoNumber> makePool() {
        return IntStream.range(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static Set<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numberPool);

        Set<LottoNumber> numbers = new TreeSet<>(Comparator.comparingInt(LottoNumber::getNumber));
        for (int i = START_INCLUSIVE; i < LottoMachine.LOTTO_SIZE; i++) {
            numbers.add(numberPool.get(i));
        }

        return Collections.unmodifiableSet(numbers);
    }
}
