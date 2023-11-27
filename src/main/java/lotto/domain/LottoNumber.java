package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN_LIST_SIZE = 0;
    private static final int MAX_LIST_SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private static List<Integer> NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());;

    private LottoNumber() {}

    public static List<Integer> randomList() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(MIN_LIST_SIZE, MAX_LIST_SIZE);
    }

    public static void check(Set<Integer> numbers) {
        for (Integer number : numbers) {
            check(number);
        }
    }

    private static void check(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("유효하지 않은 범위입니다.");
        }
    }
}
