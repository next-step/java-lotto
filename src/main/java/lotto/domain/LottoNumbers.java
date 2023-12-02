package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;

    private static List<Integer> NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());;

    private LottoNumbers() {}

    public static List<Integer> randomList() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(MIN_SIZE, MAX_SIZE);
    }

    public static void check(Set<Integer> numbers) {
        if (numbers.isEmpty() || numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("유효하지 않은 로또입니다.");
        }
        for (Integer number : numbers) {
            LottoNumber.check(number);
        }
    }
}
