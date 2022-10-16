package lotto.domain.lottonumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberFactory {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final List<Integer> numbers = IntStream
            .range(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static Set<LottoNumber> getNumbers(int number) {
        return getIntegers(number).stream().map(i -> new LottoNumber(i)).collect(Collectors.toSet());
    }

    private static List<Integer> getIntegers(int number) {
        Collections.shuffle(numbers);
        return numbers.subList(0, number).stream().sorted().collect(Collectors.toList());
    }
}
