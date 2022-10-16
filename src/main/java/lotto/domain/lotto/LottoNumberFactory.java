package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberFactory {

    private static final List<Integer> numbers = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    );

    public static Set<LottoNumber> getNumbers(int number) {
        return getIntegers(number).stream().map(i -> new LottoNumber(i)).collect(Collectors.toSet());
    }

    private static List<Integer> getIntegers(int number) {
        Collections.shuffle(numbers);
        return numbers.subList(0, number).stream().sorted().collect(Collectors.toList());
    }

}
