package lotto_step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static List<Integer> NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());;

    private LottoNumber() {}

    public static List<Integer> randomList() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(0, 6);
    }

    public static void check(Set<Integer> numbers) {
        for (Integer number : numbers) {
            check(number);
        }
    }

    private static void check(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("유효하지 않은 범위입니다.");
        }
    }
}
