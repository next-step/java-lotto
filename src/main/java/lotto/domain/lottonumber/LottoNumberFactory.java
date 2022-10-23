package lotto.domain.lottonumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberFactory {

    private static final Set<Integer> numbers = IntStream
            .range(LottoNumber.LOTTONUMBER_MINIMUM, LottoNumber.LOTTONUMBER_MAXIMUM)
            .boxed()
            .collect(Collectors.toSet());

    public static Set<LottoNumber> getNumbers(final int number) {
        return getIntegers(number).stream().map(i -> LottoNumber.get(i)).collect(Collectors.toSet());
    }

    private static Set<Integer> getIntegers(final int number) {
        final List<Integer> integerList = numbers.stream().collect(Collectors.toList());
        Collections.shuffle(integerList);
        return integerList.subList(0, number).stream().collect(Collectors.toSet());
    }
}
